package com.mall.ums.domain.member.entity;

import com.mall.ums.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
@Slf4j
class MemberTest extends BaseTest {
    @Autowired
    private Member member;

    @Test
    void testRegister() {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUsername("laozhang");
        loginInfo.setPassword("112233");

        member.setLoginInfo(loginInfo);
        member.register();
    }
}