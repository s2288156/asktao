package com.asktao.ums.domain.admin;

import com.asktao.ums.domain.admin.entity.Admin;

/**
 * @author wcy
 */
public interface IAdminDomainService {

    /**
     * 后台管理端用户注册
     *
     * @param admin 管理端用户信息
     */
    void register(Admin admin);
}
