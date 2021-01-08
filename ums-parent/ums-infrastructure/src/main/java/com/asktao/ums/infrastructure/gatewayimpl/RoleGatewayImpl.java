package com.asktao.ums.infrastructure.gatewayimpl;

import com.asktao.ums.domain.gateway.RoleGateway;
import com.asktao.ums.infrastructure.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wcy
 */
@Service
public class RoleGatewayImpl implements RoleGateway {

    @Autowired
    private RoleMapper roleMapper;

}
