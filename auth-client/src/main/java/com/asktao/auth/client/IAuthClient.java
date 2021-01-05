package com.asktao.auth.client;

import com.asktao.auth.dto.LoginCmd;
import com.asktao.lib.domain.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wcy
 */
//@FeignClient(value = "auth")
public interface IAuthClient {

    @PostMapping("/client/login")
    RestResponse<?> login(@RequestBody LoginCmd loginCmd);

}
