package com.mall.ums.infrastructure.gatewayimpl;

import com.mall.lib.ex.BizException;
import com.mall.lib.ex.ResultCodeEnum;
import com.mall.ums.domain.gateway.MemberGateway;
import com.mall.ums.domain.member.entity.Member;
import com.mall.ums.domain.member.entity.RegisterInfo;
import com.mall.ums.infrastructure.convertor.MemberConvertor;
import com.mall.ums.infrastructure.dataobject.UserDO;
import com.mall.ums.infrastructure.enums.AccountTypeEnum;
import com.mall.ums.infrastructure.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author wcy
 */
@Slf4j
@Component
public class MemberGatewayImpl implements MemberGateway {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(Member registerMember) {
        RegisterInfo registerInfo = registerMember.getRegisterInfo();
        UserDO userDO = new UserDO();
        userDO.setUsername(registerInfo.getUsername());
        userDO.setPassword(registerInfo.getPassword());
        userDO.setAccountType(AccountTypeEnum.MEMBER);
        userMapper.insert(userDO);
    }

    @Override
    public Member selectByUsername(String username) {
        Optional<UserDO> userOptional = userMapper.selectByUsername(username);
        if (userOptional.isEmpty()) {
            return null;
        }
        return MemberConvertor.loginDetailAssemble(userOptional.get());
    }

    @Override
    public Member selectById(String id) {
        UserDO userDO = userMapper.selectById(id);
        if (userDO != null) {
            return MemberConvertor.detailAssemble(userDO);
        }
        return null;
    }
}
