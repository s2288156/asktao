package com.mall.ums.domain.member.entity;

import com.mall.ums.infrastructure.dataobject.UserDO;
import lombok.Data;

/**
 * 登录信息
 *
 * @author wcy
 */
@Data
public class LoginInfo {
    private String username;

    private String password;

    UserDO convert2Do() {
        UserDO userDO = new UserDO();
        userDO.setUsername(this.getUsername());
        userDO.setPassword(this.getPassword());
        return userDO;
    }
}
