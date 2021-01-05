package com.asktao.ums.application.service.impl;

import com.asktao.ums.BaseTest;
import com.asktao.ums.application.dto.MemberRegisterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author wcy
 */
@Transactional
class AccountServiceImplTest extends BaseTest {

    @Autowired
    private AccountServiceImpl accountService;

    private String uid;
    private String username;
    private String password;
    private MemberRegisterDTO memberRegisterDTO;

    @BeforeEach
    void setUp() {
        username = "Zhang";
        password = "112233";
        memberRegisterDTO = new MemberRegisterDTO(username, password);
    }

    @Test
    void testMemberRegister() {
        assertDoesNotThrow(() -> accountService.registerMember(memberRegisterDTO));
    }

}