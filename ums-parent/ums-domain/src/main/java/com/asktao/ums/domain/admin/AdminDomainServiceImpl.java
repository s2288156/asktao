package com.asktao.ums.domain.admin;

import com.asktao.lib.domain.AbstractPageQuery;
import com.asktao.lib.domain.PageResult;
import com.asktao.lib.ex.BizException;
import com.asktao.lib.ex.ResultCodeEnum;
import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.domain.gateway.AdminGateway;
import com.asktao.ums.domain.gateway.AdminRoleGateway;
import com.asktao.ums.domain.gateway.RoleGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wcy
 */
@Slf4j
@Service
public class AdminDomainServiceImpl implements IAdminDomainService {

    @Autowired
    private AdminGateway adminGateway;

    @Autowired
    private RoleGateway roleGateway;

    @Autowired
    private AdminRoleGateway adminRoleGateway;

    @Override
    public String register(Admin admin) {
        if (adminGateway.existForUsername(admin)) {
            throw new BizException(ResultCodeEnum.USERNAME_EXISTS);
        }
        String uid = adminGateway.insert(admin);
        admin.setId(uid);
        adminRoleGateway.addAdminRole(admin);
        return uid;
    }

    @Override
    public Admin loadAdminLoginInfo(String username) {
        Admin admin = adminGateway.selectByUsername(username);
        if (admin == null) {
            throw new BizException(ResultCodeEnum.USERNAME_EXISTS);
        }
        return admin;
    }

    @Override
    public PageResult<Admin> pageAdmin(AbstractPageQuery pageQuery) {
        return adminGateway.pageQuery(pageQuery);
    }

    @Override
    public void update(Admin admin) {
        adminGateway.update(admin);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateRoles(Admin admin) {
        adminRoleGateway.deleteAllForUid(admin.getId());
        adminRoleGateway.batchAddAdminRole(admin);
    }

}
