package com.asktao.mall.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author wcy-auto
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@TableName(autoResultMap = true, value = "t_user")
public class UserDO {

    private String id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String username;

    private String password;

    private String name;

    /**
     * 男 - MALE; 女 - FEMALE
     **/
    private String sex;

    /**
     * 手机号
     **/
    private String mobile;

    /**
     * 生日
     **/
    private LocalDateTime birthday;

    private String email;

}
