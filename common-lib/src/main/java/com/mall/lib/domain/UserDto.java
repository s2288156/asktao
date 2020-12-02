package com.mall.lib.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mall.lib.constant.AuthConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 登录用户信息
 *
 * @author wcy
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class UserDto implements Serializable {
    private static final long serialVersionUID = 6294044607064925917L;

    private String id;

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
        return AuthConstant.CLIENT_ID_PORTAL.endsWith(this.clientId);
    }
}
