package com.asktao.auth.interfaces.clientimpl;

import com.asktao.auth.client.IAuthClient;
import com.asktao.auth.dto.RegisterCmd;
import com.asktao.auth.infrastructure.convertor.AccountConverter;
import com.asktao.auth.infrastructure.mapper.AccountMapper;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@Slf4j
@RestController
public class AuthClientImpl implements IAuthClient {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void register(RegisterCmd registerCmd) {
        registerCmd.checkUid();
        accountMapper.insert(AccountConverter.convertFor(registerCmd));
    }
}
