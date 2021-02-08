package com.asktao.gateway.filter;

import com.asktao.lib.constant.AuthConstant;
import com.asktao.lib.domain.UserDto;
import com.asktao.lib.util.JsonUtils;
import com.nimbusds.jose.JWSObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.text.ParseException;

/**
 * 将请求的jwt转为string放入header中，供后续服务直接获取使用
 *
 * @author wcy
 */
@Slf4j
@Order(0)
@Component
public class AuthGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isBlank(token)) {
            return chain.filter(exchange);
        }
        String realToken = token.replace(AuthConstant.JWT_TOKEN_PREFIX, "");
        JWSObject jwsObject = null;
        try {
            jwsObject = JWSObject.parse(realToken);
        } catch (ParseException e) {
            log.error("jwt parse异常", e);
        }
        String userStr = jwsObject.getPayload().toString();
        UserDto userDto = JsonUtils.fromJson(userStr, UserDto.class);
        ServerHttpRequest request = exchange.getRequest()
                .mutate()
                .header(AuthConstant.USER_ID_HEADER, userDto.getId())
                .build();
        exchange = exchange.mutate().request(request).build();
        return chain.filter(exchange);
    }
}
