package com.asktao.auth.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author wcy
 */
@FeignClient(value = "auth", path = "/auth")
public interface IAuthClient {
}
