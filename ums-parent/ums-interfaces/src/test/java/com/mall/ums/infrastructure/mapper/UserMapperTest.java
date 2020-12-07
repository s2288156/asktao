package com.mall.ums.infrastructure.mapper;

import com.mall.ums.BaseTest;
import com.mall.ums.infrastructure.dataobject.UserDO;
import com.mall.ums.infrastructure.enums.AccountTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
@Slf4j
class UserMapperTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    void testInsert() {
        UserDO userDO = new UserDO();
        userDO.setUsername("laowang");
        userDO.setPassword("123456");
        userDO.setAccountType(AccountTypeEnum.MEMBER);
        int insert = userMapper.insert(userDO);
        assertEquals(1, insert);
        log.warn("userId = {}", userDO.getId());
        assertNotNull(userDO.getId());
    }
}