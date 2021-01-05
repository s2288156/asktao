package com.asktao.ums.application.dto;

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

}
