package com.asktao.ums.application.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wcy
 */
@FeignClient(value = "auth-server", path = "/auth")
public interface AuthClient {

    @PostMapping("/oauth/token")
    ResponseEntity<?> oauthToken(@RequestParam Map<String, String> params);
}
