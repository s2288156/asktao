package com.asktao.ums.domain.admin;

import com.asktao.ums.domain.gateway.AdminGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wcy
 */
@Service
public class AdminDomainServiceImpl implements IAdminDomainService {

    @Autowired
    private AdminGateway adminGateway;

    @Override
    public String register() {
        return adminGateway.insert();
    }

}
