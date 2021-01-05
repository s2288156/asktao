package com.asktao.ums.application.service.impl;

import com.asktao.auth.client.IOauthClient;
import com.asktao.ums.application.dto.LoginCmd;
import com.asktao.ums.application.dto.MemberRegisterDTO;
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
    private IOauthClient oauthClient;


    @Override
    public void registerMember(MemberRegisterDTO memberRegister) {
        Member registerMember = new Member();
        registerMember.setRegisterInfo(memberRegister.getRegisterInfo());
        memberDomainService.register(registerMember);
    }

    @Override
    public Member detailForUid(String uid) {
        return memberDomainService.detail(uid);
    }

    @Override
    public ResponseEntity<?> login(LoginCmd loginCmd) {
        Map<String, String> params = new HashMap<>(16);
        params.put("client_id", loginCmd.getClientId());
        params.put("client_secret", "123456");
        params.put("grant_type", "password");
        params.put("username", loginCmd.getUsername());
        params.put("password", loginCmd.getPassword());
        return oauthClient.oauthToken(params);
    }

    @Override
    public void registerAdmin(AdminAccountRegisterCmd accountRegisterCmd) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(accountRegisterCmd, admin);
        admin.setPassword(accountRegisterCmd.encodePwd());
        adminDomainService.register(admin);
    }

}
