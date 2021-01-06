package com.asktao.ums.application.service.impl;

import com.asktao.auth.client.IAuthClient;
import com.asktao.auth.client.IOauthClient;
import com.asktao.ums.application.dto.LoginCmd;
import com.asktao.ums.application.dto.MemberRegisterCmd;
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
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private IAuthClient authClient;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void registerMember(MemberRegisterCmd memberRegister) {
        String uid = memberDomainService.register();
        memberRegister.setId(uid);
        authClient.register(memberRegister);
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
        // TODO: 2021/1/6 管理员注册逻辑修改
//        admin.setPassword(accountRegisterCmd.encodePwd());
        adminDomainService.register(admin);
    }

}
