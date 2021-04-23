package com.asktao.gateway.config;

import com.asktao.lib.domain.RestResponse;
import com.asktao.lib.util.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author wcy
 */
@Slf4j
@Configuration
public class ExceptionHandler implements ErrorWebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        ServerHttpResponse response = serverWebExchange.getResponse();
        if (response.isCommitted()) {
            return Mono.error(throwable);
        }
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

        return response.writeWith(Mono.fromSupplier(() -> {
            DataBufferFactory factory = response.bufferFactory();
            try {
                return factory.wrap(JsonUtils.getObjectMapper().writeValueAsBytes(RestResponse.failed(throwable.getMessage())));
            } catch (JsonProcessingException e) {
                log.error("json解析异常", e);
                return factory.wrap(new byte[0]);
            }

        }));
    }
}
