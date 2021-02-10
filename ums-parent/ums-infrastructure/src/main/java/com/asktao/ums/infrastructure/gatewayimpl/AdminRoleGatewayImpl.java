package com.asktao.ums.infrastructure.gatewayimpl;

import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.domain.gateway.AdminRoleGateway;
import com.asktao.ums.infrastructure.dataobject.AdminRoleDO;
import com.asktao.ums.infrastructure.mapper.AdminRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wcy
 */
@Service
public class AdminRoleGatewayImpl implements AdminRoleGateway {
    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public void deleteAllForUid(String uid) {
        adminRoleMapper.delete(new LambdaQueryWrapper<AdminRoleDO>()
                .eq(AdminRoleDO::getAdminId, uid)
        );
    }

    @Override
    public void addAdminRole(Admin admin) {
        AdminRoleDO adminRoleDO = new AdminRoleDO();
        adminRoleDO.setAdminId(admin.getId());
        adminRoleDO.setRoleId(admin.gustRoleId());
        adminRoleMapper.insert(adminRoleDO);
    }

    @Override
    public void batchAddAdminRole(Admin admin) {
        admin.getRoleIds().forEach(roleId -> {
            AdminRoleDO adminRoleDO = new AdminRoleDO();
            adminRoleDO.setAdminId(admin.getId());
            adminRoleDO.setRoleId(roleId);
            adminRoleMapper.insert(adminRoleDO);
        });
    }
}
