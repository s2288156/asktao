package com.asktao.security.service;

import com.asktao.security.dto.SecurityUser;

/**
 * @author wuyang
 */
public interface IUserSecurityGateway {

    SecurityUser selectUserByUsername(String username);
}
