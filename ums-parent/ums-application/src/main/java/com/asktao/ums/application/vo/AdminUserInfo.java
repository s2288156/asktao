package com.asktao.ums.application.vo;

import com.asktao.lib.dto.DTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AdminUserInfo extends DTO implements Serializable {
    private static final long serialVersionUID = 6970647468413745911L;

    private List<String> roles;

    private String name;

    private String avatar;
}
