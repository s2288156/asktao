package com.mall.ums.domain.member.entity;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mall.ums.BaseTest;
import com.mall.ums.infrastructure.dataobject.UserDO;
import com.mall.ums.infrastructure.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
@Slf4j
class MemberTest extends BaseTest {
    @Autowired
    private Member member;

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    void testRegister() {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUsername("laozhang");
        loginInfo.setPassword("112233");

        member.setLoginInfo(loginInfo);
        member.register();

        UserDO userDO = userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getUsername, loginInfo.getUsername()));
        assertNotNull(userDO);
        log.warn("userDO = {}", userDO);
    }
}