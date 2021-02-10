package com.asktao.ums.domain.gateway;

import com.asktao.ums.domain.admin.entity.Admin;

/**
 * @author wcy
 */
public interface AdminRoleGateway {

    void deleteAllForUid(String uid);

    void addAdminRole(Admin admin);

    void batchAddAdminRole(Admin admin);
}
