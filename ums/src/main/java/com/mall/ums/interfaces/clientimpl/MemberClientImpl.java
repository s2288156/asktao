package com.mall.ums.interfaces.clientimpl;

import com.mall.lib.domain.RestResult;
import com.mall.ums.application.service.IAccountService;
import com.mall.ums.client.IMemberClient;
import com.mall.ums.dto.MemberInfoDto;
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
    public RestResult<MemberInfoDto> login(String username) {
        MemberInfoDto memberInfoDto = accountService.memberLogin(username);
        return RestResult.success(memberInfoDto);
    }

}
