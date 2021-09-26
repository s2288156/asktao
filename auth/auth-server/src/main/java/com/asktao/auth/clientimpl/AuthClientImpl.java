package com.asktao.auth.clientimpl;

import com.asktao.auth.client.IAuthClient;
import com.asktao.lib.dto.SingleResponse;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyang
 */
@RestController
public class AuthClientImpl implements IAuthClient {
    @Override
    public SingleResponse<?> publicKey() {
        return SingleResponse.of("xxxxxxxxxxxx");
    }
}
