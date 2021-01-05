package com.asktao.auth.dto;

import com.asktao.lib.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginCmd extends Command {

    /**
     * 登录用户名
     **/
    private String username;

    /**
     * 登录密码
     **/
    private String password;

    /**
     * 账户手机号
     **/
    private String mobile;

    /**
     * 账户邮箱
     **/
    private String email;

}
