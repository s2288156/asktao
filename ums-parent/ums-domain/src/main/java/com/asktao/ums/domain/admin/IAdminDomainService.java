package com.asktao.ums.domain.admin;

import com.asktao.lib.domain.AbstractPageQuery;
import com.asktao.lib.domain.PageResult;
import com.asktao.ums.domain.admin.entity.Admin;

import java.util.Set;

/**
 * @author wcy
 */
public interface IAdminDomainService {

    /**
     * 后台管理端用户注册
     *
     * @return
     * @param admin
     */
    String register(Admin admin);

    Set<String> getRolesById(String uid);

    Admin loadAdminLoginInfo(String username);

    PageResult<Admin> pageAdmin(AbstractPageQuery pageQuery);

    void update(Admin admin);
}
