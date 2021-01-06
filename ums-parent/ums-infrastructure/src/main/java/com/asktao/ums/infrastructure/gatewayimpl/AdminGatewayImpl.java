package com.asktao.ums.infrastructure.gatewayimpl;

import com.asktao.ums.domain.gateway.AdminGateway;
import com.asktao.ums.infrastructure.dataobject.AdminDO;
import com.asktao.ums.infrastructure.mapper.AdminMapper;
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
    public String insert() {
        AdminDO adminDO = new AdminDO();
        adminMapper.insert(adminDO);
        return adminDO.getId();
    }
}
