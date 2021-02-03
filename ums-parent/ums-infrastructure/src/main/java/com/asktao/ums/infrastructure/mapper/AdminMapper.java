package com.asktao.ums.infrastructure.mapper;

import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.infrastructure.dataobject.AdminDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author wcy
 */
public interface AdminMapper extends BaseMapper<AdminDO> {

    Page<Admin> pageAdmin(IPage<Admin> page);

}
