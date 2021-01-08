package com.asktao.ums.infrastructure.mapper;

import com.asktao.ums.infrastructure.dataobject.RoleDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Set;

/**
 * @author wcy
 */
public interface RoleMapper extends BaseMapper<RoleDO> {

    Set<String> selectRolesByUid(String uid);

}
