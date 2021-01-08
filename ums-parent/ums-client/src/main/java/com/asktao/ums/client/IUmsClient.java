package com.asktao.ums.client;

import com.asktao.lib.domain.RestResponse;
import com.asktao.ums.dto.AdminInfoCO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wcy
 */
@FeignClient(value = "ums")
public interface IUmsClient {

    @GetMapping("/client/admin/roles")
    RestResponse<AdminInfoCO> getAdminRoles(@RequestParam String uid);
}
