package com.asktao.ums.client;

import com.asktao.lib.domain.RestResponse;
import com.asktao.lib.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wcy
 */
@FeignClient(value = "ums")
public interface IUmsClient {

    @PostMapping("/client/admin/login_select")
    RestResponse<UserDto> adminLoginSelect(@RequestParam String username);
}
