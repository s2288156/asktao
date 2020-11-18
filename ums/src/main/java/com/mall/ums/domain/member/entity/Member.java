package com.mall.ums.domain.member.entity;

import com.mall.ums.infrastructure.dataobject.UserDO;
import com.mall.ums.infrastructure.enums.AccountTypeEnum;
import com.mall.ums.infrastructure.mapper.UserMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author wcy
 */
@Component
public class Member {

    @Autowired
    private UserMapper userMapper;

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
    @Setter
    private LoginInfo loginInfo;

    private static final AccountTypeEnum ACCOUNT_TYPE = AccountTypeEnum.MEMBER;

    public void register() {
        UserDO userDO = loginInfo.convert2Do();
        userDO.setAccountType(ACCOUNT_TYPE);
        userMapper.insert(userDO);
    }

}
