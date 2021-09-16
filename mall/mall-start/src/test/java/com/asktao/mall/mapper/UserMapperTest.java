package com.asktao.mall.mapper;

import com.asktao.mall.NoneWebBaseTest;
import com.asktao.mall.infrastructure.dataobject.UserDO;
import com.asktao.mall.infrastructure.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wuyang
 */
@Slf4j
public class UserMapperTest extends NoneWebBaseTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testUserSelect() {
        UserDO userDO = userMapper.selectById("1");
        log.info("{}", userDO);
    }
}
