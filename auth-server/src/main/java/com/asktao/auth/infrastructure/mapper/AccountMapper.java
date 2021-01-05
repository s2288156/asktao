package com.asktao.auth.infrastructure.mapper;

import com.asktao.auth.infrastructure.dataobject.AccountDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Optional;

/**
 * @author wcy
 */
public interface AccountMapper extends BaseMapper<AccountDO> {

    default Optional<AccountDO> selectByUsername(String username) {
        AccountDO accountDO = selectOne(new LambdaQueryWrapper<AccountDO>().eq(AccountDO::getUsername, username));
        return Optional.ofNullable(accountDO);
    }

}
