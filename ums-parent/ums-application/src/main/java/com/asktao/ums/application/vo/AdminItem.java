package com.asktao.ums.application.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wcy-auto
 **/
@Data
public class AdminItem implements Serializable {
    private static final long serialVersionUID = -73171005836472364L;

    private String id;

    /**
     * 名字
     **/
    private String name;

    /**
     * 性别，0 - 未知，1 - 男，2 - 女
     **/
    private Integer gender;

    /**
     * 账户状态，0 - 删除，1 - 正常，2 - 冻结
     **/
    private Integer status;

    /**
     * 登录用户名
     **/
    private String username;

}
