package com.asktao.mall.infrastructure.gwimpl;

import com.asktao.lib.ex.BizException;
import com.asktao.lib.ex.CodeEnum;
import com.asktao.mall.infrastructure.dataobject.UserDO;
import com.asktao.mall.infrastructure.mapper.UserMapper;
import com.asktao.security.dto.SecurityUser;
import com.asktao.security.service.IUserSecurityGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author wuyang
 */
@Component
public class UserSecurityGateway implements IUserSecurityGateway {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SecurityUser selectUserByUsername(String username) {
        Optional<UserDO> userOptional = userMapper.selectByUsername(username);
        if (userOptional.isEmpty()) {
            throw new BizException(CodeEnum.USER_NOT_EXISTS);
        }
        return null;
    }
}
