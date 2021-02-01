package com.asktao.gateway.authorization;

import com.asktao.gateway.config.IgnoreUrlsConfig;
import com.asktao.lib.constant.AuthConstant;
import com.asktao.lib.domain.UserDto;
import com.asktao.lib.util.JsonUtils;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

    PathMatcher pathMatcher;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        URI uri = request.getURI();
        pathMatcher = new AntPathMatcher();
        // 白名单路径 或者 跨域预请求放行
        List<String> ignoreUrls = ignoreUrlsConfig.getUrls();
        for (String ignoreUrl : ignoreUrls) {
            if (pathMatcher.match(ignoreUrl, uri.getPath()) || request.getMethod() == HttpMethod.OPTIONS) {
                return Mono.just(allow());
            }
        }
        // 无token拒绝访问
        final String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isBlank(token)) {
            return Mono.just(reject());
        }
        final String realToken = token.replace(AuthConstant.JWT_TOKEN_PREFIX, "");

        // 不同用户体系登录不允许互相访问
        try {
            if (!userBelongsToRequestSystem(realToken, uri.getPath())) {
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
        Set<String> authorities = matchUrlAuthorities(uri);
        return mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(authorities::contains)
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(reject());
    }

    /**
     * 从redis中取出resource集合，获取与uri匹配的ROLES
     */
    private Set<String> matchUrlAuthorities(URI uri) {
        Map<Object, Object> resourceRolesMap = redisTemplate.opsForHash().entries(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        Iterator<Object> iterator = resourceRolesMap.keySet().iterator();
        Set<String> authorities = new HashSet<>();
        while (iterator.hasNext()) {
            String resourceUrlPattern = (String) iterator.next();
            if (pathMatcher.match(resourceUrlPattern, uri.getPath())) {
                authorities.addAll((ArrayList) resourceRolesMap.get(resourceUrlPattern));
            }
        }
        return authorities.stream()
                .map(i -> i = AuthConstant.AUTHORITY_PREFIX + i)
                .collect(Collectors.toSet());
    }

    /**
     * 判断用户是否属于请求的系统，不同用户体系登录不允许互相访问
     *
     * @return 如果clientId和url匹配则返回true，否则返回false
     */
    private boolean userBelongsToRequestSystem(String realToken, String path) throws ParseException {
        JWSObject jwsObject = JWSObject.parse(realToken);
        String userStr = jwsObject.getPayload().toString();
        UserDto userDto = JsonUtils.fromJson(userStr, UserDto.class);
        //  admin-app 只能匹配 /admin/...相关url admin + /admin/... -> true, admin + /other/... -> false
        //  portal-app 不能匹配 /admin/...相关url  portal + /admin/... -> false, portal + /other/... -> true
        if (userDto.isAdminClientId() && pathMatcher.match(AuthConstant.ADMIN_URL_PATTERN, path)) {
            return true;
        }
        return userDto.isPortalClientId() && !pathMatcher.match(AuthConstant.ADMIN_URL_PATTERN, path);
    }

    private AuthorizationDecision allow() {
        return new AuthorizationDecision(true);
    }

    private AuthorizationDecision reject() {
        return new AuthorizationDecision(false);
    }

}
