package com.asktao.auth.client;

import com.asktao.lib.dto.SingleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wuyang
 */
@FeignClient(value = "auth")
public interface IAuthClient {

    @GetMapping("/public-key")
    SingleResponse<?> publicKey();
}
