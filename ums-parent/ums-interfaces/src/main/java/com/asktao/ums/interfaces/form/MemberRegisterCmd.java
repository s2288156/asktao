package com.asktao.ums.interfaces.form;

import com.asktao.ums.application.dto.MemberRegisterDTO;
import com.asktao.ums.dto.RegisterCmd;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MemberRegisterCmd extends RegisterCmd {

    public MemberRegisterDTO convert2Dto() {
        MemberRegisterDTO memberRegisterDTO = new MemberRegisterDTO();
        memberRegisterDTO.setUsername(getUsername());
        memberRegisterDTO.setPassword(encodePwd());
        return memberRegisterDTO;
    }
}
