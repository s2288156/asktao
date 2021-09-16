package com.asktao.mall.execute.cmd;

import com.asktao.lib.base.AbstractExe;
import com.asktao.mall.convertor.UserConvertor;
import com.asktao.mall.dto.cmd.UserRegisterCmd;
import com.asktao.mall.infrastructure.dataobject.UserDO;
import com.asktao.mall.infrastructure.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author wuyang
 */
@Component
public class UserRegisterExe extends AbstractExe<UserRegisterCmd, Void> {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Void execute(UserRegisterCmd param) {
        UserDO userDO = UserConvertor.INSTANCE.userRegisterCmd2UserDo(param);
        userDO.setPassword(passwordEncoder.encode(param.getPassword()));
        userMapper.insert(userDO);
        return null;
    }

}
