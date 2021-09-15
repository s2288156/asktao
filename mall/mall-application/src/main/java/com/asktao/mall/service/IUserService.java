package com.asktao.mall.service;

import com.asktao.mall.dto.cmd.UserLoginCmd;
import com.asktao.mall.dto.vo.UserLoginVo;

/**
 * @author wuyang
 */
public interface IUserService {

    UserLoginVo login(UserLoginCmd userLoginCmd);

}
