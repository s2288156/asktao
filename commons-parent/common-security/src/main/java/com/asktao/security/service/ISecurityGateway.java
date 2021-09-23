package com.asktao.security.service;

import com.asktao.security.dto.SecurityUser;

/**
 * @author wuyang
 */
public interface ISecurityGateway {

    SecurityUser selectUserByUsername(String username);
}
