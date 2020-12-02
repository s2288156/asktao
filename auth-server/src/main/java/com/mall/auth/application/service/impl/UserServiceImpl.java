package com.mall.auth.application.service.impl;

import com.mall.auth.application.dto.SecurityUser;
import com.mall.lib.constant.AuthConstant;
import com.mall.lib.constant.MessageConstant;
import com.mall.lib.domain.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author wcy
 */
@Slf4j
@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static UserDto userDto1;
    private static UserDto userDto2;

    static {
        userDto1 = new UserDto();
        userDto2 = new UserDto();
        userDto1.setId("1");
        userDto1.setClientId("admin-app");
        userDto1.setUsername("admin");
        userDto1.setRoles(Arrays.asList("ADMIN", "B", "C"));

        userDto2.setId("2");
        userDto2.setClientId("portal-app");
        userDto2.setUsername("portal");
        userDto2.setRoles(Arrays.asList("A1", "B1", "C1"));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String adminPassword = passwordEncoder.encode("admin");
        userDto1.setPassword(adminPassword);
        userDto2.setPassword(adminPassword);
        String clientId = request.getParameter("client_id");
        UserDto userDto;
        if (AuthConstant.ADMIN_CLIENT_ID.equals(clientId)) {
            userDto = userDto1;
        } else {
            userDto = userDto2;
        }
        if (userDto == null) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        userDto.setClientId(clientId);
        SecurityUser securityUser = new SecurityUser(userDto);
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }
}
