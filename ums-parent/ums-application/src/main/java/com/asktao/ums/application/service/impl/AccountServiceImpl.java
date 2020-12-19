package com.asktao.ums.application.service.impl;

import com.asktao.lib.constant.AuthConstant;
import com.asktao.ums.application.dto.MemberLoginCmd;
import com.asktao.ums.application.dto.MemberRegisterDTO;
import com.asktao.ums.application.service.AuthClient;
import com.asktao.ums.application.service.IAccountService;
import com.asktao.ums.domain.admin.IAdminDomainService;
import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.domain.member.IMemberDomainService;
import com.asktao.ums.domain.member.entity.Member;
import com.asktao.ums.dto.AdminAccountRegisterCmd;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wcy
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IMemberDomainService memberDomainService;

    @Autowired
    private IAdminDomainService adminDomainService;

    @Autowired
    private AuthClient authClient;

    @Override
    public void registerMember(MemberRegisterDTO memberRegister) {
        Member registerMember = new Member();
        registerMember.setRegisterInfo(memberRegister.getRegisterInfo());
        memberDomainService.register(registerMember);
    }

    @Override
    public Member memberLoginSelect(String username) {
        return memberDomainService.loginSelect(username);
    }

    @Override
    public Member detailForUid(String uid) {
        return memberDomainService.detail(uid);
    }

    @Override
    public ResponseEntity<?> login(MemberLoginCmd loginCmd) {
        Map<String, String> params = new HashMap<>(16);
        params.put("client_id", AuthConstant.CLIENT_ID_PORTAL);
        params.put("client_secret", "123456");
        params.put("grant_type", "password");
        params.put("username", loginCmd.getUsername());
        params.put("password", loginCmd.getPassword());
        return authClient.oauthToken(params);
    }

    @Override
    public void registerAdmin(AdminAccountRegisterCmd accountRegisterCmd) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(accountRegisterCmd, admin);
        adminDomainService.register(admin);
    }

}
