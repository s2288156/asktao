package com.asktao.auth.dto;

import com.asktao.lib.domain.ReturnCodeMsg;
import com.asktao.lib.dto.Command;
import com.asktao.lib.ex.BizException;
import com.asktao.lib.ex.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    public String encodePwd() {
        return new BCryptPasswordEncoder().encode(password);
    }

    public void checkUid() {
        if (StringUtils.isBlank(id)) {
            log.error("uid不能为空");
            throw new BizException(ResultCodeEnum.USER_REGISTER_ERROR);
        }
    }
}
