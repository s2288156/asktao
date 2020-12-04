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
}
