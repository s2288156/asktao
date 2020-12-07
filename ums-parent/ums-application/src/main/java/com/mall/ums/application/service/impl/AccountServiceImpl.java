package com.mall.ums.application.service.impl;

import com.mall.ums.application.dto.MemberRegisterDTO;
import com.mall.ums.application.service.IAccountService;
import com.mall.ums.domain.member.IMemberDomainService;
import com.mall.ums.domain.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wcy
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IMemberDomainService memberDomainService;

    @Override
    public void registerMember(MemberRegisterDTO memberRegister) {
        Member registerMember = new Member();
        registerMember.setRegisterInfo(memberRegister.getRegisterInfo());
        memberDomainService.register(registerMember);
    }

    @Override
    public Member memberLogin(String username) {
        return memberDomainService.login(username);
    }

    @Override
    public Member detailForUid(String uid) {
        return memberDomainService.detail(uid);
    }
}
