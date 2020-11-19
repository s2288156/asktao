package com.mall.ums.application.service;

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
     * @param member 账号和密码
     */
    void registerMember(Member member);
}
