package com.asktao.ums.domain.gateway;

import com.asktao.ums.domain.member.entity.Member;

/**
 * @author wcy
 */
public interface MemberGateway {

    void insertUser(Member registerMember);

    Member selectByUsername(String username);

    Member selectById(String id);
}
