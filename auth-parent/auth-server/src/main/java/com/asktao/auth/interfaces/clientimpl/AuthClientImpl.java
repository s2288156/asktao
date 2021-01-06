package com.asktao.auth.interfaces.clientimpl;

import com.asktao.auth.client.IAuthClient;
import com.asktao.auth.dto.RegisterCmd;
import com.asktao.auth.infrastructure.convertor.AccountConverter;
import com.asktao.auth.infrastructure.dataobject.AccountDO;
import com.asktao.auth.infrastructure.mapper.AccountMapper;
import com.asktao.lib.domain.RestResponse;
import com.asktao.lib.ex.BizException;
import com.asktao.lib.ex.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author wcy
 */
@Slf4j
@RestController
public class AuthClientImpl implements IAuthClient {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public RestResponse<?> register(RegisterCmd registerCmd) {
        registerCmd.checkUid();
        Optional<AccountDO> optional = accountMapper.selectByUsername(registerCmd.getUsername());
        if (optional.isPresent()) {
            throw new BizException(ResultCodeEnum.USERNAME_EXISTS);
        }
        accountMapper.insert(AccountConverter.convertFor(registerCmd));
        return RestResponse.success();
    }
}
