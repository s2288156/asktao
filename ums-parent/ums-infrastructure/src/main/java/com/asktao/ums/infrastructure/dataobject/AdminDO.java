package com.asktao.ums.infrastructure.dataobject;

import com.asktao.ums.domain.gateway.enums.GenderEnum;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author wcy-auto
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@TableName(autoResultMap = true, value = "t_admin")
public class AdminDO {

    private String id;

    /**
     * 注册时间
     **/
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

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
    private GenderEnum gender;

    /**
     * 账户状态，0 - 删除，1 - 正常，2 - 冻结
     **/
    private Integer status;

    /**
     * 生日
     **/
    private LocalDate birthday;

    /**
     * 头像
     **/
    private String icon;

    /**
     * 登录用户名
     **/
    private String username;

    /**
     * 密码
     **/
    private String password;

    /**
     * 手机号
     **/
    private String mobile;

    /**
     * 电子邮箱
     **/
    private String email;

}
