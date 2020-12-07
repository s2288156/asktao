package com.mall.ums.infrastructure.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.ums.infrastructure.dataobject.UserDO;

import java.util.Optional;

/**
 * @author wcy
 */
public interface UserMapper extends BaseMapper<UserDO> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return userDo
     */
    default Optional<UserDO> selectByUsername(String username) {
        return Optional.ofNullable(selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getUsername, username)));
    }
}
