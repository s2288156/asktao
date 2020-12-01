package com.mall.ums.client;

import com.mall.lib.domain.RestResult;
import com.mall.ums.dto.MemberRegisterForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wcy
 */
@FeignClient("ums")
public interface IMemberClient {

    @PostMapping("/member/register")
    RestResult<?> register(@Validated MemberRegisterForm memberRegisterForm);
}
