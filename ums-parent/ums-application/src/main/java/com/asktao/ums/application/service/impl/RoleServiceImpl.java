package com.asktao.ums.application.service.impl;

import com.asktao.ums.application.cmd.role.RoleAssignCmd;
import com.asktao.ums.application.service.IRoleService;
import com.asktao.ums.application.vo.RoleVo;
import com.asktao.ums.domain.admin.IAdminDomainService;
import com.asktao.ums.domain.role.IRoleDomainService;
import com.asktao.ums.domain.role.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wcy
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDomainService roleDomainService;

    @Autowired
    private IAdminDomainService adminDomainService;

    @Override
    public Set<RoleVo> allForUid(String uid) {
        Set<Role> allRoles = roleDomainService.allForUid(uid);
        return allRoles.stream().map(RoleVo::createForDomain).collect(Collectors.toSet());
    }

    @Override
    public void assignRole(RoleAssignCmd roleAssignCmd) {
        adminDomainService.updateRoles(roleAssignCmd.convert2Admin());
    }

    @Override
    public Set<RoleVo> all() {
        return roleDomainService.all()
                .stream()
                .map(RoleVo::createForDomain)
                .collect(Collectors.toSet());
    }

}
