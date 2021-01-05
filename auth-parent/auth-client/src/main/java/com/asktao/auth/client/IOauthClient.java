package com.asktao.auth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wcy
 */
@FeignClient(contextId = "oauthClient", value = "auth")
public interface IOauthClient {
    @PostMapping("/oauth/token")
    ResponseEntity<?> oauthToken(@RequestParam Map<String, String> params);
}
