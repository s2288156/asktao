package com.asktao.controller;

import com.asktao.lib.dto.SingleResponse;
import com.asktao.mall.dto.cmd.UserLoginCmd;
import com.asktao.mall.dto.cmd.UserRegisterCmd;
import com.asktao.mall.dto.vo.UserLoginVo;
import com.asktao.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyang
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public SingleResponse<UserLoginVo> login(@Validated UserLoginCmd userLoginCmd) {
        return SingleResponse.of(userService.login(userLoginCmd));
    }

    @PostMapping("/register")
    public SingleResponse<?> register(@Validated UserRegisterCmd userRegisterCmd) {
        return SingleResponse.buildSuccess();
    }
}
