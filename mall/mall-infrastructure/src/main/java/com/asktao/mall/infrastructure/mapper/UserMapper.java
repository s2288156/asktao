package com.asktao.mall.infrastructure.mapper;

import com.asktao.mall.infrastructure.dataobject.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Optional;

/**
 * @author wuyang
 */
public interface UserMapper extends BaseMapper<UserDO> {

    Optional<UserDO> selectByUsername(String username);
}
