package com.asktao.auth.infrastructure.convertor;

import com.asktao.auth.dto.RegisterCmd;
import com.asktao.auth.infrastructure.dataobject.AccountDO;

/**
 * @author wcy
 */
public class AccountConverter {

    public static AccountDO convertFor(RegisterCmd registerCmd) {
        AccountDO accountDO = new AccountDO();
        accountDO.setId(registerCmd.getId());
        accountDO.setUsername(registerCmd.getUsername());
        accountDO.setPassword(registerCmd.encodePwd());
        return accountDO;
    }
}
