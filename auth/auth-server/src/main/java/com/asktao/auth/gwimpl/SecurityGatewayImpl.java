package com.asktao.auth.gwimpl;

import com.asktao.security.dto.SecurityUser;
import com.asktao.security.service.ISecurityGateway;
import org.springframework.stereotype.Component;

/**
 * @author wuyang
 */
@Component
public class SecurityGatewayImpl implements ISecurityGateway {



    @Override
    public SecurityUser selectUserByUsername(String username) {
        return null;
    }
}
