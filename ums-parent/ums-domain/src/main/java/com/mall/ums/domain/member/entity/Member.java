package com.mall.ums.domain.member.entity;

import com.mall.lib.constant.AuthConstant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

/**
 * @author wcy
 */
@Slf4j
@Data
public class Member {

    private String id;

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

    private RegisterInfo registerInfo;

    private static final String CLIENT_ID = AuthConstant.CLIENT_ID_PORTAL;

    public String clientId() {
        return CLIENT_ID;
    }
}
