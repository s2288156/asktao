package com.asktao.auth.client;

import com.asktao.auth.dto.RegisterCmd;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author wcy
 */
@FeignClient(contextId = "authClient", value = "auth")
public interface IAuthClient {

    void register(RegisterCmd registerCmd);
}
