package com.asktao.ums.client;

import com.asktao.lib.domain.RestResponse;
import com.asktao.lib.domain.UserDto;
import com.asktao.ums.dto.AdminInfoCO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wcy
 */
@FeignClient(value = "ums")
public interface IUmsClient {

    @PostMapping("/client/admin/roles")
    RestResponse<AdminInfoCO> getAdminRoles(@RequestParam String uid);

    @PostMapping("/client/admin/login")
    RestResponse<UserDto> adminLogin(@RequestParam String username);
}
