package com.mall.ums.interfaces.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author wcy
 */
@Data
public class MemberRegisterForm {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
}
