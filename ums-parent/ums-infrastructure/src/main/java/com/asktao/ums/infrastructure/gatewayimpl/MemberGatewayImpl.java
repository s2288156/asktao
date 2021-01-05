package com.asktao.ums.infrastructure.gatewayimpl;

import com.asktao.ums.domain.gateway.MemberGateway;
import com.asktao.ums.domain.member.entity.Member;
import com.asktao.ums.infrastructure.convertor.MemberConvertor;
import com.asktao.ums.infrastructure.dataobject.MemberDO;
import com.asktao.ums.infrastructure.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wcy
 */
@Slf4j
@Component
public class MemberGatewayImpl implements MemberGateway {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public String insertUser() {
        MemberDO memberDO = new MemberDO();
        memberMapper.insert(memberDO);
        return memberDO.getId();
    }

    @Override
    public Member selectById(String id) {
        MemberDO memberDO = memberMapper.selectById(id);
        if (memberDO != null) {
            return MemberConvertor.detailAssemble(memberDO);
        }
        return null;
    }
}
