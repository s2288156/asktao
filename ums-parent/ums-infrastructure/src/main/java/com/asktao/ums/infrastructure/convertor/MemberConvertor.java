package com.asktao.ums.infrastructure.convertor;

import com.asktao.ums.domain.member.entity.Member;
import com.asktao.ums.infrastructure.dataobject.MemberDO;
import org.springframework.beans.BeanUtils;

/**
 * @author wcy
 */
public class MemberConvertor {


    public static Member detailAssemble(MemberDO memberDO) {
        Member member = new Member();
        BeanUtils.copyProperties(memberDO, member);
        return member;
    }
}
