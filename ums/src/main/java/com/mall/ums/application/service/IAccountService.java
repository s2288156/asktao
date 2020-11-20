package com.mall.ums.application.service;

import com.mall.ums.application.dto.MemberRegisterDTO;

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
}
