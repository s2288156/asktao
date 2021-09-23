package com.asktao.security.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wuyang
 */
@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private ISecurityGateway securityGateway;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String clientId = request.getHeader("client-id");
        log.info(">>>> {}", clientId);
        return securityGateway.selectUserByUsername(username);
    }
}
