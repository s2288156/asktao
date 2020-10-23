package com.mall.lib.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mall.lib.constant.AuthConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 登录用户信息
 * Created by macro on 2020/6/19.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class UserDto {
    private Long id;

    @JsonProperty(value = "user_name")
    private String username;

    private String password;

    @JsonProperty(value = "client_id")
    private String clientId;

    private List<String> roles;

    public boolean isAdminClientId() {
        return AuthConstant.ADMIN_CLIENT_ID.equals(this.clientId);
    }

    public boolean isPortalClientId() {
        return AuthConstant.PORTAL_CLIENT_ID.endsWith(this.clientId);
    }
}
