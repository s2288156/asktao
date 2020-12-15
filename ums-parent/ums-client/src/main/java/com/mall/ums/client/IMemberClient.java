package com.mall.ums.client;

import com.mall.lib.domain.RestResponse;
import com.mall.ums.dto.MemberInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wcy
 */
@FeignClient(value = "ums", path = "/ums")
public interface IMemberClient {

    @PostMapping("/member_login")
    RestResponse<MemberInfoDto> login(@RequestParam String username);
}
