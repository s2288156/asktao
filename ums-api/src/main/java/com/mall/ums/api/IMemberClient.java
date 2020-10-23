package com.mall.ums.api;

import com.mall.lib.domain.RestResult;
import com.mall.lib.domain.UserDto;
import com.mall.ums.dto.MemberRegisterDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wcy
 */
@FeignClient(value = "ums")
public interface IMemberClient {
    @GetMapping("/member/by_username")
    RestResult<UserDto> getMemberByUserName(String username);

    @PostMapping("/member/register")
    RestResult<UserDto> register(MemberRegisterDto memberRegister);
}
