package com.asktao.ums.domain.gateway;

import com.asktao.lib.domain.PageQuery;
import com.asktao.lib.domain.PageResult;
import com.asktao.ums.domain.admin.entity.Admin;

/**
 * @author wcy
 */
public interface AdminGateway {

    String insert(Admin admin);

    boolean existForUsername(Admin admin);

    void insertDefaultGustRole(Admin admin);

    Admin selectByUsername(String username);

    PageResult<Admin> pageQuery(PageQuery pageQuery);
}
