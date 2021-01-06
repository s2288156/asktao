package com.asktao.ums.interfaces.controller.admin;

import com.asktao.lib.domain.RestResponse;
import com.asktao.ums.application.dto.AdminLoginCmd;
import com.asktao.ums.application.service.IAccountService;
import com.asktao.ums.application.dto.AdminAccountRegisterCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台管理端账户
 *
 * @author wcy
 */
@Validated
@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/register")
    public RestResponse<?> register(AdminAccountRegisterCmd registerCmd) {
        accountService.registerAdmin(registerCmd);
        return RestResponse.success();
    }

    @PostMapping("/login")
    public RestResponse<?> login(AdminLoginCmd loginCmd) {
        return RestResponse.success(accountService.login(loginCmd));
    }

}
