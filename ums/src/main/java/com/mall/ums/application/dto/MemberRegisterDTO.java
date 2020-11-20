package com.mall.ums.application.dto;

import com.mall.ums.domain.member.entity.RegisterInfo;
import lombok.Data;

/**
 * @author wcy
 */
@Data
public class MemberRegisterDTO {

    private String username;

    private String password;

    public RegisterInfo getRegisterInfo() {
        RegisterInfo registerInfo = new RegisterInfo();
        registerInfo.setUsername(getUsername());
        registerInfo.setPassword(getPassword());
        return registerInfo;
    }

}
