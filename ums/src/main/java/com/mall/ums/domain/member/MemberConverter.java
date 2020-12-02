package com.mall.ums.domain.member;

import com.mall.lib.constant.AuthConstant;
import com.mall.ums.dto.MemberInfoDto;
import com.mall.ums.infrastructure.dataobject.UserDO;

/**
 * @author wcy
 */
public class MemberConverter {

    public static MemberInfoDto userDo2UserDto(UserDO userDO) {
        MemberInfoDto memberInfoDto = new MemberInfoDto();
        memberInfoDto.setUsername(userDO.getUsername());
        memberInfoDto.setPassword(userDO.getPassword());
        memberInfoDto.setId(userDO.getId());
        memberInfoDto.setClientId(AuthConstant.CLIENT_ID_PORTAL);

        return memberInfoDto;
    }
}
