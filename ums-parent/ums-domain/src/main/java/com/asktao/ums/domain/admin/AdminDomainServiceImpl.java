package com.asktao.ums.domain.admin;

import com.asktao.lib.ex.BizException;
import com.asktao.lib.ex.ResultCodeEnum;
import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.domain.gateway.AdminGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wcy
 */
@Service
public class AdminDomainServiceImpl implements IAdminDomainService{

    @Autowired
    private AdminGateway adminGateway;

    @Override
    public void register(Admin admin) {
        final boolean existAccount = adminGateway.existForUsername(admin.getUsername());
        if (existAccount) {
            throw new BizException(ResultCodeEnum.USERNAME_EXISTS);
        }
        adminGateway.insert(admin);
    }
}
