package com.mall.auth.interfaces.controller;

import com.mall.lib.domain.RestResult;
import com.mall.ums.client.IMemberClient;
import com.mall.ums.dto.MemberRegisterForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@Slf4j
@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IMemberClient memberClient;

    @PostMapping("/member_register")
    public RestResult<?> memberRegister(@Validated MemberRegisterForm memberRegisterForm) {
        memberRegisterForm.setPassword(passwordEncoder.encode(memberRegisterForm.getPassword()));
        memberClient.register(memberRegisterForm);
        return RestResult.success();
    }
}
