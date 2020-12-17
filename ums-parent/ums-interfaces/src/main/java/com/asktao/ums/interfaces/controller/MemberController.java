package com.asktao.ums.interfaces.controller;

import com.asktao.lib.domain.RestResponse;
import com.asktao.ums.application.dto.MemberLoginCmd;
import com.asktao.ums.application.service.IAccountService;
import com.asktao.ums.domain.member.entity.Member;
import com.asktao.ums.interfaces.form.MemberRegisterForm;
import com.asktao.ums.interfaces.vo.MemberDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author wcy
 */
@RequestMapping("/member")
@RestController
public class MemberController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/register")
    public RestResponse<?> register(@Validated MemberRegisterForm memberRegister) {
        accountService.registerMember(memberRegister.convert2Dto());
        return RestResponse.success();
    }

    @GetMapping("/detail")
    public RestResponse<MemberDetailVO> detail(@RequestHeader String uid) {
        Member member = accountService.detailForUid(uid);
        return RestResponse.success(MemberDetailVO.assembleFor(member));
    }

    @PostMapping("/login")
    public RestResponse<?> login(@Validated MemberLoginCmd loginCmd) {
        return RestResponse.success(accountService.login(loginCmd).getBody());
    }
}
