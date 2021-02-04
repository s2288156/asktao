package com.asktao.ums.infrastructure.convertor;

import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.infrastructure.dataobject.AdminDO;
import org.springframework.beans.BeanUtils;

/**
 * @author wcy
 */
public class AdminConvertor {
    public static AdminDO convertDomain2Do(Admin admin) {
        AdminDO adminDO = new AdminDO();
        BeanUtils.copyProperties(admin, adminDO);
        return adminDO;
    }
}
