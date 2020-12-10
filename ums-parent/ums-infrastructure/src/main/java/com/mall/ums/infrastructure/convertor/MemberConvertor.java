package com.mall.ums.infrastructure.convertor;

import com.mall.ums.domain.member.entity.LoginInfo;
import com.mall.ums.domain.member.entity.Member;
import com.mall.ums.infrastructure.dataobject.UserDO;
import org.springframework.beans.BeanUtils;

/**
 * @author wcy
 */
public class MemberConvertor {

    public static Member loginDetailAssemble(UserDO userDO) {
        Member member = new Member();
        member.setLoginInfo(new LoginInfo(userDO.getUsername(), userDO.getPassword()));
        member.setId(userDO.getId());
        return member;
    }

    public static Member detailAssemble(UserDO userDO) {
        Member member = new Member();
        BeanUtils.copyProperties(userDO, member);
        return member;
    }
}
