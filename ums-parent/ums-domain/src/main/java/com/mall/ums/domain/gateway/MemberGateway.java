package com.mall.ums.domain.gateway;

import com.mall.ums.domain.member.entity.Member;

/**
 * @author wcy
 */
public interface MemberGateway {

    void insertUser(Member registerMember);

    Member selectByUsername(String username);

    Member selectById(String id);
}
