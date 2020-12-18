package com.asktao.ums.interfaces.controller.admin;

import com.asktao.lib.domain.RestResponse;
import com.asktao.ums.interfaces.form.AdminAccountRegisterCmd;
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
@RequestMapping("/admin/account")
@RestController
public class AccountController {

    @PostMapping("/register")
    public RestResponse<?> register(AdminAccountRegisterCmd registerCmd) {

        return RestResponse.success();
    }
}
