package com.mall.ums.application.service;

import com.mall.lib.domain.UserDto;
import com.mall.ums.application.dto.MemberRegisterDTO;
import com.mall.ums.dto.MemberInfoDto;

/**
 * 账户相关
 *
 * @author wcy
 */
public interface IAccountService {

    /**
     * 注册会员
     *
     * @param memberRegister 账号和密码
     */
    void registerMember(MemberRegisterDTO memberRegister);

    /**
     * 用户登录，根据username查询用户密码信息，交由spring security鉴权
     *
     * @param username 用户名
     * @return 用户信息
     */
    MemberInfoDto memberLogin(String username);
}
