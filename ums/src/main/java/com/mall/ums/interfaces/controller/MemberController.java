package com.mall.ums.interfaces.controller;

import com.mall.lib.domain.RestResult;
import com.mall.ums.application.service.IAccountService;
import com.mall.ums.interfaces.form.MemberRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RequestMapping("/member")
@RestController
public class MemberController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/register")
    public RestResult<?> register(@Validated MemberRegisterForm memberRegister) {
        accountService.registerMember(memberRegister.convert2Dto());
        return RestResult.success();
    }
}
