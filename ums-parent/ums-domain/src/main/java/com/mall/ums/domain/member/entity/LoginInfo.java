package com.mall.ums.domain.member.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录信息
 *
 * @author wcy
 */
@NoArgsConstructor
@Data
public class LoginInfo {
    private String username;

    private String password;

    public LoginInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
