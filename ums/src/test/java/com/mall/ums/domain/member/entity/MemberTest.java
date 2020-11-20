package com.mall.ums.domain.member.entity;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mall.lib.ex.BizException;
import com.mall.lib.ex.ResultCodeEnum;
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
        RegisterInfo registerInfo = new RegisterInfo();
        registerInfo.setUsername("loaaaaaaa");
        registerInfo.setPassword("1123455");

        member.setRegisterInfo(registerInfo);
        member.register();

        UserDO userDO = userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getUsername, registerInfo.getUsername()));
        assertNotNull(userDO);
        log.warn("userDO = {}", userDO);

        BizException bizException = assertThrows(BizException.class, () -> member.register());
        assertEquals(ResultCodeEnum.USERNAME_EXISTS.code(), bizException.getCode());
    }
}