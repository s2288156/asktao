package com.asktao.ums.infrastructure.mapper;

import com.asktao.ums.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
class RoleMapperTest extends BaseTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void selectRolesByUid() {
        Set<String> roles = roleMapper.selectRolesByUid("375514151688327168");
        System.out.println(roles);
    }
}