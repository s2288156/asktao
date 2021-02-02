package com.asktao.ums.application.vo;

import com.asktao.lib.domain.RestResponse;
import com.asktao.lib.domain.UserDto;
import com.asktao.lib.dto.DTO;
import com.asktao.lib.ex.ResultCodeEnum;
import com.asktao.lib.ex.SysException;
import com.asktao.lib.util.JsonUtils;
import com.nimbusds.jose.JWSObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Set;

/**
 * @author wcy
 */
@Slf4j
@EqualsAndHashCode(callSuper = true)
@Data
public class AdminUserInfo extends DTO implements Serializable {
    private static final long serialVersionUID = 6970647468413745911L;

    private Set<String> roles;

    private String name;

    private String avatar;

    public static AdminUserInfo createForToken(String token) {
        JWSObject jwsObject;
        try {
            jwsObject = JWSObject.parse(token);
        } catch (ParseException e) {
            log.error("jws Parse error:", e);
            throw new SysException(ResultCodeEnum.SYS_EXECUTE_ERROR);
        }
        String userStr = jwsObject.getPayload().toString();
        UserDto userDto = JsonUtils.fromJson(userStr, UserDto.class);

        AdminUserInfo adminUserInfo = new AdminUserInfo();
        adminUserInfo.setRoles(userDto.getAuthorities());
        adminUserInfo.setName(userDto.getName());
        adminUserInfo.setAvatar(userDto.getAvatar());
        return adminUserInfo;
    }
}
