package com.asktao.ums.interfaces.clientimpl;

import com.asktao.lib.domain.RestResponse;
import com.asktao.ums.application.service.IAccountService;
import com.asktao.ums.client.IMemberClient;
import com.asktao.ums.domain.member.entity.Member;
import com.asktao.ums.dto.MemberInfoDto;
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
    public RestResponse<MemberInfoDto> loginSelect(String username) {
        Member member = accountService.memberLoginSelect(username);
        MemberInfoDto memberInfoDto = assembleMemberInfoFor(member);
        return RestResponse.success(memberInfoDto);
    }

    private MemberInfoDto assembleMemberInfoFor(Member member) {
        MemberInfoDto memberInfoDto = new MemberInfoDto();
        memberInfoDto.setId(member.getId());
        memberInfoDto.setUsername(member.getLoginInfo().getUsername());
        memberInfoDto.setPassword(member.getLoginInfo().getPassword());
        memberInfoDto.setClientId(member.clientId());
        return memberInfoDto;
    }

}
