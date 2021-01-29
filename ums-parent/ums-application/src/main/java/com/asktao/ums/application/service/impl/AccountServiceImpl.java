package com.asktao.ums.application.service.impl;

import com.asktao.auth.client.IAuthClient;
import com.asktao.auth.client.IOauthClient;
import com.asktao.auth.dto.RegisterCmd;
import com.asktao.lib.domain.RestResponse;
import com.asktao.lib.domain.UserDto;
import com.asktao.lib.ex.BizException;
import com.asktao.ums.application.dto.AdminAccountRegisterCmd;
import com.asktao.ums.application.dto.LoginCmd;
import com.asktao.ums.application.dto.MemberRegisterCmd;
import com.asktao.ums.application.service.IAccountService;
import com.asktao.ums.domain.admin.IAdminDomainService;
import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.domain.member.IMemberDomainService;
import com.asktao.ums.domain.member.entity.Member;
import com.asktao.ums.dto.AdminInfoCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        authRegisterAccount(memberRegister);
    }

    /**
     * @param registerCmd 账户信息
     */
    private void authRegisterAccount(RegisterCmd registerCmd) {
        RestResponse<?> response = authClient.register(registerCmd);
        if (response.bad()) {
            throw new BizException(response.getCode(), response.getMessage());
        }
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void registerAdmin(AdminAccountRegisterCmd accountRegisterCmd) {
        adminDomainService.register(accountRegisterCmd.convert2Admin());
    }

    @Override
    public AdminInfoCO getAdminRoles(String uid) {
        Set<String> rolesName = adminDomainService.getRolesById(uid);
        return new AdminInfoCO(rolesName);
    }

    @Override
    public UserDto loadAdmin(String username) {
        Admin admin = adminDomainService.loadAdminLoginInfo(username);
        return convert2UserDto(admin);
    }

    private UserDto convert2UserDto(Admin admin) {
        UserDto userDto = new UserDto();
        userDto.setId(admin.getId());
        userDto.setUsername(admin.getUsername());
        userDto.setPassword(admin.getPassword());
        userDto.setRoles(admin.getRoles());
        userDto.setClientId(admin.clientId());
        return userDto;
    }

}
