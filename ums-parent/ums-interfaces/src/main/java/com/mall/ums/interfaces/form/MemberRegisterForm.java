package com.mall.ums.interfaces.form;

import com.mall.ums.application.dto.MemberRegisterDTO;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    public MemberRegisterDTO convert2Dto() {
        MemberRegisterDTO memberRegisterDTO = new MemberRegisterDTO();
        memberRegisterDTO.setUsername(getUsername());
        memberRegisterDTO.setPassword(new BCryptPasswordEncoder().encode(getPassword()));
        return memberRegisterDTO;
    }
}
