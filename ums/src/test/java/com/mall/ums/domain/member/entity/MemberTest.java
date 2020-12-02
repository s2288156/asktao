package com.mall.ums.domain.member.entity;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mall.lib.constant.AuthConstant;
import com.mall.lib.domain.UserDto;
import com.mall.lib.ex.BizException;
import com.mall.lib.ex.ResultCodeEnum;
import com.mall.ums.BaseTest;
import com.mall.ums.dto.MemberInfoDto;
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
        String username = "loaaaaaaa";
        String password = "1123455";
        registerMember(username, password);

        UserDO userDO = userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getUsername, username));
        assertNotNull(userDO);
        log.warn("userDO = {}", userDO);

        BizException bizException = assertThrows(BizException.class, () -> member.register());
        assertEquals(ResultCodeEnum.USERNAME_EXISTS.code(), bizException.getCode());
    }

    @Test
    @Transactional
    void testLogin() {
        String username = "test_laowang";
        String password = "112233";

        registerMember(username, password);

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUsername(username);

        member.setRegisterInfo(null);
        MemberInfoDto memberInfoDto = member.login(username);

        assertEquals(password, memberInfoDto.getPassword());
        assertEquals(AuthConstant.CLIENT_ID_PORTAL, memberInfoDto.getClientId());
        log.warn(">>>>> {}", memberInfoDto);
    }

    private void registerMember(String username, String password) {
        RegisterInfo registerInfo = new RegisterInfo();
        registerInfo.setUsername(username);
        registerInfo.setPassword(password);

        member.setRegisterInfo(registerInfo);
        member.register();
    }
}