package com.mall.ums.domain.member;

import com.mall.lib.constant.AuthConstant;
import com.mall.lib.domain.UserDto;
import com.mall.ums.infrastructure.dataobject.UserDO;

/**
 * @author wcy
 */
public class MemberConverter {

    public static UserDto userDo2UserDto(UserDO userDO) {
        UserDto userDto = new UserDto();
        userDto.setUsername(userDO.getUsername());
        userDto.setPassword(userDO.getPassword());
        userDto.setId(userDO.getId());
        userDto.setClientId(AuthConstant.CLIENT_ID_PORTAL);

        return userDto;
    }
}
