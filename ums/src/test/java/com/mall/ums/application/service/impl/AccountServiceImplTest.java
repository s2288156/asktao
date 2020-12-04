package com.mall.ums.application.service.impl;

import com.mall.ums.BaseTest;
import com.mall.ums.application.dto.MemberRegisterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author wcy
 */
class AccountServiceImplTest extends BaseTest {

    @Autowired
    private AccountServiceImpl accountService;

    @Test
    @Transactional
    void testMemberRegister() {
        MemberRegisterDTO memberRegisterDTO = new MemberRegisterDTO();
        memberRegisterDTO.setUsername("Zhang");
        memberRegisterDTO.setPassword("112233");
        assertDoesNotThrow(() -> accountService.registerMember(memberRegisterDTO));
    }


}