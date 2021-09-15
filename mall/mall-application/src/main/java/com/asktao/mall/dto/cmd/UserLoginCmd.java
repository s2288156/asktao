package com.asktao.mall.dto.cmd;

import com.asktao.lib.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @author wuyang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserLoginCmd extends Command {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
