package com.asktao.ums.domain.admin.entity;

import com.asktao.lib.constant.AuthConstant;
import lombok.Data;

import java.util.Set;

/**
 * @author wcy
 */
@Data
public class Admin {
    private String id;

    private Set<Role> roles;

    private static final String CLIENT_ID = AuthConstant.CLIENT_ID_ADMIN;

    public String clientId() {
        return CLIENT_ID;
    }

}
