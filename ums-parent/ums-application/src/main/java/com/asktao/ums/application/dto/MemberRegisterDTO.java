package com.asktao.ums.application.dto;

import com.asktao.ums.domain.member.entity.RegisterInfo;
import lombok.Data;

/**
 * @author wcy
 */
@Data
public class MemberRegisterDTO {

    private String username;

    private String password;

    public MemberRegisterDTO() {
    }

    public MemberRegisterDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public RegisterInfo getRegisterInfo() {
        RegisterInfo registerInfo = new RegisterInfo();
        registerInfo.setUsername(getUsername());
        registerInfo.setPassword(getPassword());
        return registerInfo;
    }

}
