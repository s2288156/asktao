package com.asktao.ums.infrastructure.gatewayimpl;

import com.asktao.ums.domain.gateway.RoleGateway;
import com.asktao.ums.domain.role.entity.Role;
import com.asktao.ums.infrastructure.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author wcy
 */
@Service
public class RoleGatewayImpl implements RoleGateway {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Set<Role> selectAllForUid(String uid) {
        return roleMapper.listRoleByUid(uid);
    }

    @Override
    public Set<Role> listAll() {
        return roleMapper.listAll();
    }
}
