package com.asktao.ums.dto;

import com.asktao.lib.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;

/**
 * @author wcy
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RegisterCmd extends Command {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    public String encodePwd() {
        return new BCryptPasswordEncoder().encode(password);
    }
}
