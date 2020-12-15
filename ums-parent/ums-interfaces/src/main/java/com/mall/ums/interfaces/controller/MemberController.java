package com.mall.ums.interfaces.controller;

import com.mall.lib.domain.RestResponse;
import com.mall.ums.application.service.IAccountService;
import com.mall.ums.domain.member.entity.Member;
import com.mall.ums.interfaces.form.MemberRegisterForm;
import com.mall.ums.interfaces.vo.MemberDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> login(String username, String password) {
        return accountService.login(username, password);
    }
}
