package com.asktao.security.service;

import com.asktao.security.dto.SecurityUser;

/**
 * @author wuyang
 */
public interface ISecurityUserService {

    SecurityUser selectUserByUsername(String username);
}
