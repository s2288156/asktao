package com.asktao.ums.domain.member;

import com.asktao.ums.domain.gateway.MemberGateway;
import com.asktao.ums.domain.member.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wcy
 */
@Slf4j
@Service
public class MemberDomainServiceImpl implements IMemberDomainService {

    @Autowired
    private MemberGateway memberGateway;

    @Override
    public String register() {
        String id = memberGateway.insertUser();
        return id;
    }

    @Override
    public Member detail(String uid) {
        return memberGateway.selectById(uid);
    }

}
