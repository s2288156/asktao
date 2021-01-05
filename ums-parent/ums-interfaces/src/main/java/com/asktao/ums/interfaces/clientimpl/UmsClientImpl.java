package com.asktao.ums.interfaces.clientimpl;

import com.asktao.lib.domain.RestResponse;
import com.asktao.lib.domain.UserDto;
import com.asktao.ums.application.service.IAccountService;
import com.asktao.ums.client.IUmsClient;
import com.asktao.ums.domain.admin.entity.Admin;
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
    public RestResponse<UserDto> adminLoginSelect(String username) {
        Admin admin = accountService.adminLoginSelect(username);
        UserDto userDto = assembleUserDtoFor(admin);

        return RestResponse.success(userDto);
    }

    private UserDto assembleUserDtoFor(Admin admin) {
        UserDto userDto = new UserDto();
        userDto.setClientId(admin.clientId());
        userDto.setId(admin.getId());
        userDto.setUsername(admin.getUsername());
        userDto.setPassword(admin.getPassword());
        return userDto;
    }

}
