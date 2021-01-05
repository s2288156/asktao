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

    Member detail(String uid);
}
