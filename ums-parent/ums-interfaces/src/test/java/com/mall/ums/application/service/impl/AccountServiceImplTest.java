package com.mall.ums.application.service.impl;

import com.mall.lib.ex.BizException;
import com.mall.ums.BaseTest;
import com.mall.ums.application.dto.MemberRegisterDTO;
import com.mall.ums.domain.member.entity.Member;
import com.mall.ums.infrastructure.dataobject.UserDO;
import com.mall.ums.infrastructure.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
@Transactional
class AccountServiceImplTest extends BaseTest {

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private UserMapper userMapper;

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

    @Test
    void testLogin() {
        accountService.registerMember(memberRegisterDTO);
        Member member = accountService.memberLoginSelect(username);
        assertEquals(password, member.getLoginInfo().getPassword());

        assertThrows(BizException.class, () -> accountService.memberLoginSelect("error"));
    }

    @Test
    void testDetailForUid() {
        testMemberRegister();
        Optional<UserDO> userDO = userMapper.selectByUsername(username);
        uid = userDO.get().getId();
        Member member = accountService.detailForUid(uid);
        assertNotNull(member);
    }
}