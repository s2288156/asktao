package com.mall.gateway.authorization;

import com.mall.gateway.config.IgnoreUrlsConfig;
import com.mall.lib.constant.AuthConstant;
import com.mall.lib.domain.UserDto;
import com.mall.lib.util.JsonUtils;
import com.nimbusds.jose.JWSObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 鉴权管理器，用于判断是否有资源的访问权限
 *
 * @author wcy
 */
@Slf4j
@Component
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        URI uri = request.getURI();
        log.info("request uri path = {}, rawPath = {}", uri.getPath(), uri.getRawPath());
        PathMatcher pathMatcher = new AntPathMatcher();
        // 白名单路径 或者 跨域预请求放行
        List<String> ignoreUrls = ignoreUrlsConfig.getUrls();
        for (String ignoreUrl : ignoreUrls) {
            if (pathMatcher.match(ignoreUrl, uri.getPath()) || request.getMethod() == HttpMethod.OPTIONS) {
                return Mono.just(allow());
            }
        }
        // 无token拒绝访问
        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isBlank(token)) {
            return Mono.just(reject());
        }
        String realToken = token.replace(AuthConstant.JWT_TOKEN_PREFIX, "");

        // 不同用户体系登录不允许互相访问
        try {
            if (userBelongsToRequestSystem(realToken)) {
                return Mono.just(reject());
            }
        } catch (ParseException e) {
            log.error("jwt parse异常", e);
            return Mono.just(reject());
        }

        // 非管理端路径直接放行
        if (!pathMatcher.match(AuthConstant.DEMO_FOO_URL_PATTERN, uri.getPath())) {
            return Mono.just(allow());
        }

        // 管理端校验权限
        Map<Object, Object> resourceRolesMap = redisTemplate.opsForHash().entries(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        Iterator<Object> iterator = resourceRolesMap.keySet().iterator();
        List<String> authorities = new ArrayList<>();
        while (iterator.hasNext()) {
            String pattern = (String) iterator.next();
            if (pathMatcher.match(pattern, uri.getPath())) {
                authorities.addAll((ArrayList) resourceRolesMap.get(pattern));
                Object arg = resourceRolesMap.get(pattern);
                log.warn("{} <<<<<<<<<<<<<<", arg);
            }
        }
        authorities = authorities.stream().map(i -> i = AuthConstant.AUTHORITY_PREFIX + i).collect(Collectors.toList());
        return mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(authorities::contains)
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(reject());
    }

    /**
     * 判断用户是否属于请求的系统，不同用户体系登录不允许互相访问
     */
    private boolean userBelongsToRequestSystem(String realToken) throws ParseException {
        JWSObject jwsObject = JWSObject.parse(realToken);
        String userStr = jwsObject.getPayload().toString();
        UserDto userDto = JsonUtils.fromJson(userStr, UserDto.class);
        // TODO: 2020/10/14 根据user clientId和url pattern判断不同用户体系
        return false;
    }

    private AuthorizationDecision allow() {
        return new AuthorizationDecision(true);
    }

    private AuthorizationDecision reject() {
        return new AuthorizationDecision(false);
    }

}
