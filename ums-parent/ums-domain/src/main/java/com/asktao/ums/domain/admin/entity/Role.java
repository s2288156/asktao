package com.asktao.ums.domain.admin.entity;

import lombok.Data;

import java.util.Set;

/**
 * @author wcy
 */
@Data
public class Role {

    private Set<Resource> resources;
}
