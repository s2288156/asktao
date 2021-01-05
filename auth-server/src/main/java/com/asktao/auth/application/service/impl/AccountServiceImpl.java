package com.asktao.auth.application.service.impl;

import com.asktao.auth.application.service.IAccountService;
import com.asktao.auth.infrastructure.dataobject.AccountDO;
import com.asktao.auth.infrastructure.mapper.AccountMapper;
import com.asktao.lib.constant.MessageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author wcy
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public AccountDO selectByUsername(String username) {
        Optional<AccountDO> optional = accountMapper.selectByUsername(username);

        return optional.orElseThrow(() -> new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR));
    }

}
