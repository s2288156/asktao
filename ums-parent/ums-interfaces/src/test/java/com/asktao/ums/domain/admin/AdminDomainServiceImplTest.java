package com.asktao.ums.domain.admin;

import com.asktao.ums.BaseTest;
import com.asktao.ums.domain.admin.entity.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
class AdminDomainServiceImplTest extends BaseTest {

    @Autowired
    private IAdminDomainService adminDomainService;

    @BeforeEach
    void setUp() {
        Set<String> roleIds = new HashSet<>();
        roleIds.add("1");
        roleIds.add("2");
        roleIds.add("3");
        Admin admin = new Admin();
        admin.setId("aaaaaaaaaaaaa");
        admin.setRoleIds(roleIds);

        adminDomainService.updateRoles(admin);
    }

    @Test
    void updateRoles() {
        Set<String> roleIds = new HashSet<>();
        roleIds.add("33");
        roleIds.add("44");
        roleIds.add("1231231231231231231231231231231231312312312312312313213123123123132123123123132");
        roleIds.add("55");
        Admin admin = new Admin();
        admin.setId("aaaaaaaaaaaaa");
        admin.setRoleIds(roleIds);

        assertThrows(Exception.class, () -> adminDomainService.updateRoles(admin));
    }

    @Test
    void updateRoles2() {
        Set<String> roleIds = new HashSet<>();
        roleIds.add("33");
        roleIds.add("44");
        roleIds.add("55");
        Admin admin = new Admin();
        admin.setId("aaaaaaaaaaaaa");
        admin.setRoleIds(roleIds);
        assertDoesNotThrow(() -> adminDomainService.updateRoles(admin));
    }
}