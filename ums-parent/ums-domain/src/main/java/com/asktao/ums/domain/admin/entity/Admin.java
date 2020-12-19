package com.asktao.ums.domain.admin.entity;

import lombok.Data;

import java.util.Set;

/**
 * @author wcy
 */
@Data
public class Admin {
    private String id;

    private String username;

    private String password;

    private Set<Role> roles;


}
