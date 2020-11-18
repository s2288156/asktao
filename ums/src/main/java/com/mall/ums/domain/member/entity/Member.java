package com.mall.ums.domain.member.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author wcy
 */
@Component
public class Member {
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

    /**
     * 账户状态，0 - 删除，1 - 正常，2 - 冻结
     **/
    private Integer status;

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

    /**
     * 登录信息
     */
    private LoginInfo loginInfo;

    private void register() {

    }

}
