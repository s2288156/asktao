package com.asktao.auth.client;

import com.asktao.auth.dto.RegisterCmd;
import com.asktao.lib.domain.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wcy
 */
@FeignClient(contextId = "authClient", value = "auth")
public interface IAuthClient {

    @PostMapping("/client/register")
    RestResponse<?> register(@RequestBody RegisterCmd registerCmd);
}
