package com.mall.ums.domain.member.entity;

import com.mall.lib.ex.BizException;
import com.mall.lib.ex.ResultCodeEnum;
import com.mall.ums.infrastructure.dataobject.UserDO;
import com.mall.ums.infrastructure.enums.AccountTypeEnum;
import com.mall.ums.infrastructure.mapper.UserMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author wcy
 */
@Data
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
    private LoginInfo loginInfo;

    private RegisterInfo registerInfo;

    private static final AccountTypeEnum ACCOUNT_TYPE = AccountTypeEnum.MEMBER;

    public void register() {
        if (registerInfo == null) {
            throw new BizException(ResultCodeEnum.USER_REGISTER_ERROR);
        }
        checkUsernameNotExisted(registerInfo.getUsername());

        UserDO userDO = registerInfo.convert2Do();
        userDO.setAccountType(ACCOUNT_TYPE);
        userMapper.insert(userDO);
    }

    private void checkUsernameNotExisted(String username) {
        Optional<UserDO> optionalUserDO = userMapper.selectByUsername(username);
        if (optionalUserDO.isPresent()) {
            throw new BizException(ResultCodeEnum.USERNAME_EXISTS);
        }
    }

}
