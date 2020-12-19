package com.asktao.ums.infrastructure.convertor;

import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.infrastructure.dataobject.UserDO;

/**
 * @author wcy
 */
public class AdminConvertor {

    public static Admin loginDetailAssemble(UserDO userDO) {
        Admin admin = new Admin();
        admin.setUsername(userDO.getUsername());
        admin.setPassword(userDO.getPassword());
        admin.setId(userDO.getId());

        return admin;
    }
}
