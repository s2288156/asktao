package com.asktao.ums.client;

import com.asktao.lib.domain.RestResponse;
import com.asktao.ums.dto.MemberInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wcy
 */
@FeignClient(value = "ums", path = "/ums")
public interface IMemberClient {

    @PostMapping("/client/member/login_select")
    RestResponse<MemberInfoDto> loginSelect(@RequestParam String username);
}
