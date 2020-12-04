package com.mall.ums.application.service;

import com.mall.ums.application.dto.MemberRegisterDTO;
import com.mall.ums.domain.member.entity.Member;

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
    Member memberLogin(String username);

}
