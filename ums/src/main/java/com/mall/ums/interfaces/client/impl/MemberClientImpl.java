package com.mall.ums.interfaces.client.impl;

import com.mall.lib.domain.RestResult;
import com.mall.lib.domain.UserDto;
import com.mall.ums.api.IMemberClient;
import com.mall.ums.dto.MemberRegisterDto;

/**
 * @author wcy
 */
public class MemberClientImpl implements IMemberClient {
    @Override
    public RestResult<UserDto> getMemberByUserName(String username) {
        return null;
    }

    @Override
    public RestResult<UserDto> register(MemberRegisterDto memberRegister) {
        return null;
    }
}
