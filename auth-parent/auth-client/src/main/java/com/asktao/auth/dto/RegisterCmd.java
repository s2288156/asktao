package com.asktao.auth.dto;

import com.asktao.lib.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;

/**
 * @author wcy
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = true)
public class RegisterCmd extends Command {

    private String id;

    @NotBlank(message = "用户名不能为空")
    @Length(min = 6, max = 18, message = "The username length must be less than 6 and less than 18 characters!")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 18, message = "The password length must be less than 6 and less than 18 characters!")
    private String password;

    public String encodePwd() {
        return new BCryptPasswordEncoder().encode(password);
    }

}
