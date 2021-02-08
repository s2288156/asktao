package com.asktao.ums.application.service.impl;

import com.asktao.ums.application.service.IRoleService;
import com.asktao.ums.application.vo.RoleVo;
import com.asktao.ums.domain.role.IRoleDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wcy
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDomainService roleDomainService;

    @Override
    public List<RoleVo> allForUid(String uid) {
        return null;
    }
}
