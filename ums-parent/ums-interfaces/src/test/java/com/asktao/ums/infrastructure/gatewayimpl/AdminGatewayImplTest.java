package com.asktao.ums.infrastructure.gatewayimpl;

import com.asktao.lib.domain.AbstractPageQuery;
import com.asktao.lib.domain.PageResult;
import com.asktao.mybatis.base.PageQuery;
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
    void selectTest() {
        Admin admin = adminGateway.selectByUsername("admin");
        assertNotNull(admin);

        log.warn(">>>> {}", admin);
        Set<String> roles = admin.getRoleNames();
        assertNotNull(roles);
        assertTrue(roles.contains("ROOT"));
    }

    @Test
    void pageAdminTest() {
        AbstractPageQuery pageQuery = new PageQuery();
        pageQuery.setPage(1L);
        pageQuery.setLimit(10L);
        pageQuery.setSort("+gender");
        PageResult<Admin> adminPageResult = adminGateway.pageQuery(pageQuery);
        assertTrue(adminPageResult.getTotal() > 0);
        adminPageResult.getRecords().forEach(item -> log.warn(">>>> id = {},  time = {}, gender = {}", item.getId(), item.getCreateTime(), item.getGender()));
    }
}