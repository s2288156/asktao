package com.asktao.ums.domain.member;

import com.asktao.lib.ex.BizException;
import com.asktao.lib.ex.ResultCodeEnum;
import com.asktao.ums.domain.gateway.MemberGateway;
import com.asktao.ums.domain.member.entity.Member;
import com.asktao.ums.domain.member.entity.RegisterInfo;
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
    public void register(Member registerMember) {
        RegisterInfo registerInfo = registerMember.getRegisterInfo();
        if (registerInfo == null) {
            throw new BizException(ResultCodeEnum.USER_REGISTER_ERROR);
        }
        checkUsernameNotExisted(registerInfo.getUsername());
        memberGateway.insertUser(registerMember);
    }

    @Override
    public Member loginSelect(String username) {
        Member member = memberGateway.selectByUsername(username);
        if (member == null) {
            log.warn("用户[{}]不存在", username);
            throw new BizException(ResultCodeEnum.USER_NOT_EXISTS);
        }
        return member;
    }

    @Override
    public Member detail(String uid) {
        return memberGateway.selectById(uid);
    }

    private void checkUsernameNotExisted(String username) {
        Member member = memberGateway.selectByUsername(username);
        if (member == null) {
            throw new BizException(ResultCodeEnum.USERNAME_EXISTS);
        }
    }
}
