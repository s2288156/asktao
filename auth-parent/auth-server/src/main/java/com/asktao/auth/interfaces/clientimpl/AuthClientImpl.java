package com.asktao.auth.interfaces.clientimpl;

import com.asktao.auth.client.IAuthClient;
import com.asktao.auth.dto.RegisterCmd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@Slf4j
@RestController
public class AuthClientImpl implements IAuthClient {

    @Override
    public void register(RegisterCmd registerCmd) {

    }
}
