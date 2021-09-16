package com.asktao.mall.convertor;

import com.asktao.mall.dto.cmd.UserRegisterCmd;
import com.asktao.mall.infrastructure.dataobject.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author wuyang
 */
@Mapper
public interface UserConvertor {
    UserConvertor INSTANCE = Mappers.getMapper(UserConvertor.class);

    UserDO userRegisterCmd2UserDo(UserRegisterCmd userRegisterCmd);
}
