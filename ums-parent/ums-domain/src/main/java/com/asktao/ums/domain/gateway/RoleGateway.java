package com.asktao.ums.domain.gateway;

import com.asktao.ums.domain.role.entity.Role;

import java.util.Set;

/**
 * @author wcy
 */
public interface RoleGateway {
    Set<Role> selectAllForUid(String uid);
}
