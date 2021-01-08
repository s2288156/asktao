package com.asktao.ums.domain.admin;

import com.asktao.ums.domain.gateway.AdminGateway;
import com.asktao.ums.domain.gateway.RoleGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author wcy
 */
@Service
public class AdminDomainServiceImpl implements IAdminDomainService {

    @Autowired
    private AdminGateway adminGateway;

    @Autowired
    private RoleGateway roleGateway;

    @Override
    public String register() {
        return adminGateway.insert();
    }

    @Override
    public Set<String> getRolesById(String uid) {
        return roleGateway.selectRoleNameForUid(uid);
    }

}
