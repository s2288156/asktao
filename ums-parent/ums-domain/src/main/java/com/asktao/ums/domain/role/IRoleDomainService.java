package com.asktao.ums.domain.role;

import com.asktao.ums.domain.role.entity.Role;

import java.util.Set;

/**
 * @author wcy
 */
public interface IRoleDomainService {
    Set<Role> allForUid(String uid);
}
