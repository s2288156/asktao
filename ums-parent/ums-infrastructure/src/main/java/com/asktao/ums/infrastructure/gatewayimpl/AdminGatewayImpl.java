package com.asktao.ums.infrastructure.gatewayimpl;

import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.domain.gateway.AdminGateway;
import com.asktao.ums.infrastructure.dataobject.UserDO;
import com.asktao.ums.infrastructure.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author wcy
 */
@Service
public class AdminGatewayImpl implements AdminGateway {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(Admin admin) {
        UserDO userDO = new UserDO();
        userDO.setUsername(admin.getUsername());
        userDO.setPassword(admin.getPassword());
        userMapper.insert(userDO);
    }

    @Override
    public boolean existForUsername(String username) {
        Optional<UserDO> optionalUserDO = userMapper.selectByUsername(username);
        return optionalUserDO.isPresent();
    }


}
