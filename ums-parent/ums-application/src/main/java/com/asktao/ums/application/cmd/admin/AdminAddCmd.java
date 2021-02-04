package com.asktao.ums.application.cmd.admin;

import com.asktao.auth.dto.RegisterCmd;
import com.asktao.ums.domain.admin.entity.Admin;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AdminAddCmd extends RegisterCmd {

    private String name;

    public Admin convert2Admin() {
        Admin admin = new Admin();
        admin.setUsername(getUsername());
        admin.setPassword(encodePwd());
        admin.setName(getName());
        return admin;
    }
}
