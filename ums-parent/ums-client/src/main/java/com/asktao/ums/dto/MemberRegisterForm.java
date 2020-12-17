package com.asktao.ums.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public class MemberRegisterForm implements Serializable {

    private static final long serialVersionUID = -6874046129284891009L;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

}
