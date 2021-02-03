package com.asktao.ums.interfaces.controller.admin;

import com.asktao.lib.domain.RestResponse;
import com.asktao.lib.domain.PageQuery;
import com.asktao.ums.application.cmd.AdminAccountRegisterCmd;
import com.asktao.ums.application.cmd.AdminLoginCmd;
import com.asktao.ums.application.service.IAccountService;
import com.asktao.ums.application.vo.AdminUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台管理端账户
 *
 * @author wcy
 */
@Slf4j
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
    public RestResponse<?> login(@RequestBody AdminLoginCmd loginCmd) {
        return RestResponse.success(accountService.login(loginCmd).getBody());
    }

    @GetMapping("/user/info")
    public RestResponse<AdminUserInfo> userInfo(String token) {
        return RestResponse.success(AdminUserInfo.createForToken(token));
    }

    @PostMapping("/logout")
    public RestResponse<?> logout() {
        return RestResponse.success();
    }

    @GetMapping("/list")
    public RestResponse<?> list(PageQuery pageQuery) {
        return RestResponse.success();
    }


}
