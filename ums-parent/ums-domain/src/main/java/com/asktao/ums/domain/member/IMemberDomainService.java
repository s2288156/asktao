package com.asktao.ums.domain.member;

import com.asktao.ums.domain.member.entity.Member;

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
     * 会员登录查询
     *
     * @param username 用户名
     * @return 会员信息
     */
    Member loginSelect(String username);

    Member detail(String uid);
}
