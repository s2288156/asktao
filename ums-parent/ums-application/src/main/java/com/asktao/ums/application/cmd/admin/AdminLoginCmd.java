package com.asktao.ums.application.cmd.admin;

import com.asktao.lib.constant.AuthConstant;
import com.asktao.lib.dto.Command;
import com.asktao.ums.application.cmd.LoginCmd;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AdminLoginCmd extends Command implements LoginCmd {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 12, message = "密码必须为6至12位长度")
    private String password;

    @Override
    public String getClientId() {
        return AuthConstant.CLIENT_ID_ADMIN;
    }
}
