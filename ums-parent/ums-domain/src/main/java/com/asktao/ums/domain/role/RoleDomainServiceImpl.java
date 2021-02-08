package com.asktao.ums.domain.role;

import com.asktao.ums.domain.gateway.RoleGateway;
import com.asktao.ums.domain.role.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author wcy
 */
@Service
public class RoleDomainServiceImpl implements IRoleDomainService {
    @Autowired
    private RoleGateway roleGateway;

    @Override
    public Set<Role> allForUid(String uid) {
        return roleGateway.selectAllForUid(uid);
    }
}
