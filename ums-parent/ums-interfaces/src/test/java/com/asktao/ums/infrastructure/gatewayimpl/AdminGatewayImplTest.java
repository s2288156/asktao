package com.asktao.ums.infrastructure.gatewayimpl;

import com.asktao.lib.domain.PageQuery;
import com.asktao.lib.domain.PageResult;
import com.asktao.ums.BaseTest;
import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.domain.gateway.AdminGateway;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
@Slf4j
class AdminGatewayImplTest extends BaseTest {

    @Autowired
    private AdminGateway adminGateway;

    @Test
    void insert() {
        Admin admin = adminGateway.selectByUsername("admin");
        assertNotNull(admin);

        log.warn(">>>> {}", admin);
        Set<String> roles = admin.getRoles();
        assertNotNull(roles);
        assertTrue(roles.contains("ROOT"));
    }

    @Test
    void pageAdminTest() {
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPage(1L);
        pageQuery.setLimit(10L);
        PageResult<Admin> adminPageResult = adminGateway.pageQuery(pageQuery);
        assertTrue(adminPageResult.getTotal() > 0);
        log.warn(">>>> {}", adminPageResult.getRecords());
    }
}