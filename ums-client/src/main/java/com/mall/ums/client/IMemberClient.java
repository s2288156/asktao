package com.mall.ums.client;

import com.mall.lib.domain.RestResult;
import com.mall.ums.dto.MemberRegisterForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wcy
 */
@FeignClient("ums")
public interface IMemberClient {

    @PostMapping("/member_register")
    RestResult<?> register(@RequestBody MemberRegisterForm memberRegisterForm);
}
