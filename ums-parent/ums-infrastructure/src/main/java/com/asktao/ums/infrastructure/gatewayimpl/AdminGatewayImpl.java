package com.asktao.ums.infrastructure.gatewayimpl;

import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.domain.gateway.AdminGateway;
import com.asktao.ums.infrastructure.dataobject.AdminDO;
import com.asktao.ums.infrastructure.mapper.AdminMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wcy
 */
@Service
public class AdminGatewayImpl implements AdminGateway {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String insert(Admin admin) {
        AdminDO adminDO = new AdminDO();
        adminDO.setUsername(admin.getUsername());
        adminDO.setPassword(admin.getPassword());
        adminMapper.insert(adminDO);
        return adminDO.getId();
    }

    @Override
    public boolean existForUsername(Admin admin) {
        AdminDO adminDO = adminMapper.selectOne(new LambdaQueryWrapper<AdminDO>().eq(AdminDO::getUsername, admin.getUsername()));
        return adminDO != null;
    }

}
