package com.asktao.ums.domain.member;

import com.asktao.ums.domain.member.entity.Member;

/**
 * @author wcy
 */
public interface IMemberDomainService {
    /**
     * 会员注册
     *
     * @return
     */
    String register();

    Member detail(String uid);
}
