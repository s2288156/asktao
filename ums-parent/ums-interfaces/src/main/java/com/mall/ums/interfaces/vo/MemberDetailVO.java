package com.mall.ums.interfaces.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author wcy
 */
@Data
public class MemberDetailVO implements Serializable {
    private static final long serialVersionUID = 1134784532375459086L;

    /**
     * 名字
     **/
    private String name;

    /**
     * 年龄
     **/
    private Integer age;

    /**
     * 性别，0 - 未知，1 - 男，2 - 女
     **/
    private Integer gender;

    private String genderName;
    /**
     * 生日
     **/
    private LocalDate birthday;

    /**
     * 邮箱
     **/
    private String email;

    /**
     * 头像
     **/
    private String icon;

    /**
     * 手机号
     **/
    private String phone;
}
