package com.asktao.ums.application.cmd;

import com.asktao.auth.dto.RegisterCmd;
import com.asktao.ums.domain.admin.entity.Admin;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AdminAccountRegisterCmd extends RegisterCmd {

    public Admin convert2Admin() {
        Admin admin = new Admin();
        admin.setUsername(getUsername());
        admin.setPassword(encodePwd());
        return admin;
    }
}
