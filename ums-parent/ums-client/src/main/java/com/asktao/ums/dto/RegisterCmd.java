package com.asktao.ums.dto;

import com.asktao.lib.dto.Command;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author wcy
 */
@Data
public class RegisterCmd extends Command {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
}
