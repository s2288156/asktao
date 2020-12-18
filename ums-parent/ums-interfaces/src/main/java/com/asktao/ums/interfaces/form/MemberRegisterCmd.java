package com.asktao.ums.interfaces.form;

import com.asktao.ums.application.dto.MemberRegisterDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MemberRegisterCmd extends RegisterCmd {

    public MemberRegisterDTO convert2Dto() {
        MemberRegisterDTO memberRegisterDTO = new MemberRegisterDTO();
        memberRegisterDTO.setUsername(getUsername());
        memberRegisterDTO.setPassword(new BCryptPasswordEncoder().encode(getPassword()));
        return memberRegisterDTO;
    }
}
