package com.mall.ums.client.impl;

import com.mall.lib.domain.RestResult;
import com.mall.lib.domain.UserDto;
import com.mall.ums.api.IManagerClient;

/**
 * @author wcy
 */
public class ManagerClientImpl implements IManagerClient {
    @Override
    public RestResult<UserDto> getManagerByUserName(String username) {
        return null;
    }
}
