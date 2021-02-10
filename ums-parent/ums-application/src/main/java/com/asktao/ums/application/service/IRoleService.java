package com.asktao.ums.application.service;

import com.asktao.ums.application.cmd.role.RoleAssignCmd;
import com.asktao.ums.application.vo.RoleVo;

import java.util.Set;

/**
 * @author wcy
 */
public interface IRoleService {

    Set<RoleVo> allForUid(String uid);

    void assignRole(RoleAssignCmd roleAssignCmd);

    Set<RoleVo> all();
}
