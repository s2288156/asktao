package com.asktao.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author wuyang
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private IUserSecurityGateway userSecurityGateway;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userSecurityGateway.selectUserByUsername(username);
    }
}
