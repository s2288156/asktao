package com.asktao.ums.infrastructure.gatewayimpl;

import com.asktao.ums.BaseTest;
import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.domain.gateway.AdminRoleGateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wcy
 */
class AdminRoleGatewayImplTest extends BaseTest {

    @Autowired
    private AdminRoleGateway adminRoleGateway;

    @Test
    void batchAddAdminRole() {
        Set<String> roleIds = new HashSet<>();
        roleIds.add("1");
        roleIds.add("2");
//        roleIds.add("1231231231231231231231231231231231312312312312312313213123123123132123123123132");
        roleIds.add("3");
        Admin admin = new Admin();
        admin.setId("aaaaaaaaaaaaa");
        admin.setRoleIds(roleIds);

        adminRoleGateway.batchAddAdminRole(admin);
    }
}