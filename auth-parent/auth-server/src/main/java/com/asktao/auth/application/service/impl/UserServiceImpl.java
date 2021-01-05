package com.asktao.auth.application.service.impl;

import com.asktao.auth.application.dto.SecurityUser;
import com.asktao.auth.application.service.IAccountService;
import com.asktao.auth.infrastructure.dataobject.AccountDO;
import com.asktao.lib.constant.AuthConstant;
import com.asktao.lib.constant.MessageConstant;
import com.asktao.lib.domain.UserDto;
import com.asktao.ums.client.IUmsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wcy
 */
@Slf4j
@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IUmsClient umsClient;

    @Autowired
    private IAccountService accountService;

//        userDto1 = new UserDto();
//        userDto2 = new UserDto();
//        userDto1.setId("1");
//        userDto1.setClientId("admin-app");
//        userDto1.setUsername("admin");
//        userDto1.setRoles(Arrays.asList("ADMIN", "B", "C"));

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountDO accountDO = accountService.selectByUsername(username);
        String clientId = request.getParameter("client_id");
        UserDto userDto;
        if (AuthConstant.CLIENT_ID_ADMIN.equals(clientId)) {
            userDto = umsClient.adminLoginSelect(username).getData();
        } else {
//            MemberInfoDto memberInfoDto = umsClient.memberLoginSelect(username).getData();
//            userDto = memberInfoDto.convert2UserDto();
            userDto = new UserDto();
            userDto.setUsername(username);
            userDto.setPassword(accountDO.getPassword());
            userDto.setId(accountDO.getId());
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
