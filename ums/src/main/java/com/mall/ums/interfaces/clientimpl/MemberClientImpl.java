package com.mall.ums.interfaces.clientimpl;

import com.mall.lib.domain.RestResult;
import com.mall.lib.domain.UserDto;
import com.mall.ums.application.dto.MemberRegisterDTO;
import com.mall.ums.application.service.IAccountService;
import com.mall.ums.client.IMemberClient;
import com.mall.ums.domain.member.entity.Member;
import com.mall.ums.dto.MemberInfoDto;
import com.mall.ums.dto.MemberRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RestController
public class MemberClientImpl implements IMemberClient {

    @Autowired
    private IAccountService accountService;

    @Override
    public RestResult<?> register(MemberRegisterForm memberRegisterForm) {
        accountService.registerMember(convert2Dto(memberRegisterForm));
        return RestResult.success();
    }

    @Override
    public RestResult<MemberInfoDto> login(String username) {
        MemberInfoDto memberInfoDto = accountService.memberLogin(username);
        return RestResult.success(memberInfoDto);
    }

    private MemberRegisterDTO convert2Dto(MemberRegisterForm memberRegisterForm) {
        MemberRegisterDTO memberRegisterDTO = new MemberRegisterDTO();
        memberRegisterDTO.setUsername(memberRegisterForm.getUsername());
        memberRegisterDTO.setPassword(memberRegisterForm.getPassword());
        return memberRegisterDTO;
    }
}
