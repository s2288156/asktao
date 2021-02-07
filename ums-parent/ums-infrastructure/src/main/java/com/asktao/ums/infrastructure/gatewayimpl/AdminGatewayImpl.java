package com.asktao.ums.infrastructure.gatewayimpl;

import com.asktao.lib.domain.AbstractPageQuery;
import com.asktao.lib.domain.PageResult;
import com.asktao.lib.ex.BizException;
import com.asktao.lib.ex.ResultCodeEnum;
import com.asktao.mybatis.base.PageQuery;
import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.domain.gateway.AdminGateway;
import com.asktao.ums.infrastructure.convertor.AdminConvertor;
import com.asktao.ums.infrastructure.dataobject.AdminDO;
import com.asktao.ums.infrastructure.dataobject.AdminRoleDO;
import com.asktao.ums.infrastructure.mapper.AdminMapper;
import com.asktao.ums.infrastructure.mapper.AdminRoleMapper;
import com.asktao.ums.infrastructure.mapper.RoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author wcy
 */
@Slf4j
@Service
public class AdminGatewayImpl implements AdminGateway {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public String insert(Admin admin) {
        AdminDO adminDO = new AdminDO();
        BeanUtils.copyProperties(admin, adminDO);
        adminMapper.insert(adminDO);
        return adminDO.getId();
    }

    @Override
    public boolean existForUsername(Admin admin) {
        AdminDO adminDO = adminMapper.selectOne(new LambdaQueryWrapper<AdminDO>().eq(AdminDO::getUsername, admin.getUsername()));
        return adminDO != null;
    }

    @Override
    public void insertDefaultGustRole(Admin admin) {
        AdminRoleDO adminRoleDO = new AdminRoleDO();
        adminRoleDO.setAdminId(admin.getId());
        adminRoleDO.setRoleId(admin.gustRoleId());
        adminRoleMapper.insert(adminRoleDO);
    }

    @Override
    public Admin selectByUsername(String username) {
        AdminDO adminDO = adminMapper.selectOne(new LambdaQueryWrapper<AdminDO>().eq(AdminDO::getUsername, username));
        if (adminDO == null) {
            throw new BizException(ResultCodeEnum.USER_LOGIN_ERROR);
        }
        Set<String> rolesName = roleMapper.selectRolesByUid(adminDO.getId());

        Admin admin = new Admin();
        admin.setId(adminDO.getId());
        admin.setUsername(adminDO.getUsername());
        admin.setPassword(adminDO.getPassword());
        admin.setRoles(rolesName);
        admin.setName(adminDO.getName());
        admin.setIcon(adminDO.getIcon());
        return admin;
    }

    @Override
    public PageResult<Admin> pageQuery(AbstractPageQuery pageQuery) {
        PageQuery query = (PageQuery) pageQuery;
        Page<Admin> page = adminMapper.pageAdmin(query.createPage());
        return new PageResult<>(page.getTotal(), page.getRecords());
    }

    @Override
    public void update(Admin admin) {
        adminMapper.updateById(AdminConvertor.convertDomain2Do(admin));
    }

}
