package com.asktao.ums.interfaces.clientimpl;

import com.asktao.lib.domain.RestResponse;
import com.asktao.ums.application.service.IAccountService;
import com.asktao.ums.client.IUmsClient;
import com.asktao.ums.dto.AdminInfoCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RestController
public class UmsClientImpl implements IUmsClient {

    @Autowired
    private IAccountService accountService;

    @Override
    public RestResponse<AdminInfoCO> getAdminRoles(String uid) {
        return RestResponse.success(accountService.getAdminRoles(uid));
    }
}
