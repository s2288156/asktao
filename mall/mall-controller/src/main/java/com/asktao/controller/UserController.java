package com.asktao.controller;

import com.asktao.lib.dto.SingleResponse;
import com.asktao.mall.dto.cmd.UserLoginCmd;
import com.asktao.mall.dto.vo.UserLoginVo;
import com.asktao.security.dto.SecurityUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyang
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @PostMapping("/login")
    public SingleResponse<UserLoginVo> login(UserLoginCmd userLoginCmd) {

        return SingleResponse.buildSuccess();
    }
}
