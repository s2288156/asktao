package com.mall.ums.interfaces.controller;

import com.mall.lib.domain.RestResult;
import com.mall.ums.application.service.IAccountService;
import com.mall.ums.domain.member.entity.Member;
import com.mall.ums.interfaces.form.MemberRegisterForm;
import com.mall.ums.interfaces.vo.MemberDetailVO;
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
    public RestResult<?> register(@Validated MemberRegisterForm memberRegister) {
        accountService.registerMember(memberRegister.convert2Dto());
        return RestResult.success();
    }

    @GetMapping("/detail")
    public RestResult<MemberDetailVO> detail(@RequestHeader String uid) {
        Member member = accountService.detailForUid(uid);

        return RestResult.success(MemberDetailVO.assembleFor(member));
    }
}
