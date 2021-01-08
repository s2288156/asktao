package com.asktao.ums.domain.admin;

import com.asktao.lib.ex.BizException;
import com.asktao.lib.ex.ResultCodeEnum;
import com.asktao.ums.domain.admin.entity.Admin;
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
    public String register(Admin admin) {
        if (adminGateway.existForUsername(admin)) {
            throw new BizException(ResultCodeEnum.USERNAME_EXISTS);
        }
        String uid = adminGateway.insert(admin);
        admin.setId(uid);
        adminGateway.insertDefaultGustRole(admin);
        return uid;
    }

    @Override
    public Set<String> getRolesById(String uid) {
        return roleGateway.selectRoleNameForUid(uid);
    }

}
