package com.asktao.ums.application.service.impl;

import com.asktao.auth.client.IOauthClient;
import com.asktao.lib.domain.UserDto;
import com.asktao.lib.domain.PageQuery;
import com.asktao.lib.domain.PageResult;
import com.asktao.ums.application.cmd.LoginCmd;
import com.asktao.ums.application.cmd.admin.AdminUpdateCmd;
import com.asktao.ums.application.config.CommonValues;
import com.asktao.ums.application.service.IAccountService;
import com.asktao.ums.application.vo.AdminDetail;
import com.asktao.ums.application.vo.AdminSim;
import com.asktao.ums.domain.admin.IAdminDomainService;
import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.domain.member.IMemberDomainService;
import com.asktao.ums.dto.AdminInfoCO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
    private CommonValues commonValues;

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
    public AdminSim registerAdmin(Admin admin) {
        admin.setIcon(commonValues.getDefaultAvatar());
        String uid = adminDomainService.register(admin);
        AdminSim adminSim = new AdminSim();
        BeanUtils.copyProperties(admin, adminSim);
        adminSim.setId(uid);
        return adminSim;
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

    @Override
    public PageResult<AdminSim> pageAdmins(PageQuery pageQuery) {
        PageResult<Admin> adminPageResult = adminDomainService.pageAdmin(pageQuery);
        List<AdminSim> adminSimList = adminPageResult.getRecords()
                .stream().map(admin -> {
                    AdminSim adminSim = new AdminSim();
                    BeanUtils.copyProperties(admin, adminSim);
                    return adminSim;
                }).collect(Collectors.toList());
        return PageResult.createFor(adminPageResult.getTotal(), adminSimList);
    }

    @Override
    public void updateAdmin(AdminUpdateCmd adminUpdateCmd) {
        adminDomainService.update(adminUpdateCmd.convert2Admin());
    }

    private UserDto convert2UserDto(Admin admin) {
        UserDto userDto = new UserDto();
        userDto.setId(admin.getId());
        userDto.setUsername(admin.getUsername());
        userDto.setPassword(admin.getPassword());
        userDto.setAuthorities(admin.getRoles());
        userDto.setClientId(admin.clientId());
        userDto.setName(admin.getName());
        userDto.setAvatar(admin.getIcon());
        return userDto;
    }

}
