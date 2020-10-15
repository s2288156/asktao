package com.mall.ums.api;

import com.mall.lib.domain.RestResult;
import com.mall.lib.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wcy
 */
@FeignClient(value = "ums")
public interface IManagerClient {
    @GetMapping("/manager/by_username")
    RestResult<UserDto> getManagerByUserName(String username);
}
