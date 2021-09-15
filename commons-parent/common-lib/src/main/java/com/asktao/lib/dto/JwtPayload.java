package com.asktao.lib.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Set;

/**
 * @author wcy
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class JwtPayload {

    private String uid;

    /**
     * 失效日期时间戳，单位秒
     */
    private Long exp;

    /**
     * 签发机构
     */
    private String iss;

    private Set<String> roles;

    /**
     * 头像
     **/
    private String avatar;

    /**
     * 邮箱
     **/
    private String email;

    /**
     * 姓名
     **/
    private String name;
}
