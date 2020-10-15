package com.mall.ums.controller;

import com.mall.lib.domain.RestResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RequestMapping("/member")
@RestController
public class MemberController {

    @PostMapping("/register")
    public RestResult<?> register() {

        return RestResult.success();
    }
}
