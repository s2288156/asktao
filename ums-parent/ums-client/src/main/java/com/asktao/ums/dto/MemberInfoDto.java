package com.asktao.ums.dto;

import com.asktao.lib.domain.UserDto;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public class MemberInfoDto implements Serializable {
    private static final long serialVersionUID = 8146352744429128683L;

    private String id;

    private String username;

    private String password;

    private String clientId;

    public UserDto convert2UserDto() {
        UserDto userDto = new UserDto();
        userDto.setId(getId());
        userDto.setUsername(getUsername());
        userDto.setPassword(getPassword());
        userDto.setClientId(getClientId());
        return userDto;
    }
}
