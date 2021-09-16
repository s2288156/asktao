package com.asktao.mall.service.impl;

import com.asktao.mall.dto.cmd.UserLoginCmd;
import com.asktao.mall.dto.vo.UserLoginVo;
import com.asktao.mall.execute.cmd.UserLoginExe;
import com.asktao.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuyang
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserLoginExe userLoginExe;

    @Override
    public UserLoginVo login(UserLoginCmd userLoginCmd) {
        return userLoginExe.execute(userLoginCmd);
    }
}
