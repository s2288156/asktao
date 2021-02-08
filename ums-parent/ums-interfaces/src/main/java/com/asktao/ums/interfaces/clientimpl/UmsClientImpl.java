package com.asktao.ums.interfaces.clientimpl;

import com.asktao.lib.domain.RestResponse;
import com.asktao.lib.domain.UserDto;
import com.asktao.ums.application.service.IAccountService;
import com.asktao.ums.client.IUmsClient;
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
    public RestResponse<UserDto> adminLogin(String username) {
        return RestResponse.success(accountService.loadAdmin(username));
    }

}
