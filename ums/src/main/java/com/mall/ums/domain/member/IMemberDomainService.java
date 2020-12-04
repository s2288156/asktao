package com.mall.ums.domain.member;

import com.mall.ums.domain.member.entity.Member;

/**
 * @author wcy
 */
public interface IMemberDomainService {
    /**
     * 会员注册
     *
     * @param registerMember 注册信息
     */
    void register(Member registerMember);

    /**
     * 会员登录
     *
     * @param username 用户名
     * @return 会员信息
     */
    Member login(String username);
}
