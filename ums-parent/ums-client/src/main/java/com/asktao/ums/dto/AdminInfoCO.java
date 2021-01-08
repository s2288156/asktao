package com.asktao.ums.dto;

import com.asktao.lib.dto.DTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AdminInfoCO extends DTO {

    private Set<String> roles;

    public AdminInfoCO(Set<String> roles) {
        this.roles = roles;
    }
}
