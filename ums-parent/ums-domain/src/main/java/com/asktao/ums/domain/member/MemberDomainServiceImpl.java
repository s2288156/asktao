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
        // TODO: 2021/1/5 修改，补充注册逻辑
//        memberGateway.insertUser(registerMember);
    }

    @Override
    public Member detail(String uid) {
        return memberGateway.selectById(uid);
    }

}
