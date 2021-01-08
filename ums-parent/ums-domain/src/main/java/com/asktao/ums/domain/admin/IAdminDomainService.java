package com.asktao.ums.domain.admin;

import com.asktao.ums.domain.admin.entity.Admin;

/**
 * @author wcy
 */
public interface IAdminDomainService {

    /**
     * 后台管理端用户注册
     *
     * @return
     */
    String register();

    Admin getRolesById(String uid);
}
