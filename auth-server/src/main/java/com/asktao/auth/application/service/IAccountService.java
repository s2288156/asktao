package com.asktao.auth.application.service;

import com.asktao.auth.infrastructure.dataobject.AccountDO;

/**
 * @author wcy
 */
public interface IAccountService {

    AccountDO selectByUsername(String username);

}
