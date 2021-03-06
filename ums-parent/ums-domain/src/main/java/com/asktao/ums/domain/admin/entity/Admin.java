package com.asktao.ums.domain.admin.entity;

import com.asktao.lib.constant.AuthConstant;
import com.asktao.ums.domain.gateway.enums.AdminStatusEnum;
import com.asktao.ums.domain.gateway.enums.GenderEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author wcy
 */
@Data
public class Admin {
    private static final String ROLE_GUST_ID = "1";
    private static final String CLIENT_ID = AuthConstant.CLIENT_ID_ADMIN;

    private String id;

    private String username;

    private String password;

    private Set<String> roleNames;

    private String name;

    private String icon;

    private GenderEnum gender;

    private AdminStatusEnum status;

    private Set<String> roleIds;

    /**
     * 注册时间
     **/
    private LocalDateTime createTime;

    public String clientId() {
        return CLIENT_ID;
    }

    public String gustRoleId() {
        return ROLE_GUST_ID;
    }
}
