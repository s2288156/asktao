package com.asktao.ums.domain.gateway;

import java.util.Set;

/**
 * @author wcy
 */
public interface RoleGateway {

    Set<String> selectRoleNameForUid(String uid);

}
