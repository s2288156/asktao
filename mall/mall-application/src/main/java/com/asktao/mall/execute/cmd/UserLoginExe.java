package com.asktao.mall.execute.cmd;

import com.asktao.lib.base.AbstractExe;
import com.asktao.mall.dto.cmd.UserLoginCmd;
import com.asktao.mall.dto.vo.UserLoginVo;
import com.asktao.security.TokenService;
import com.asktao.security.dto.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @author wuyang
 */
@Component
public class UserLoginExe extends AbstractExe<UserLoginCmd, UserLoginVo> {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserLoginVo execute(UserLoginCmd param) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(param.getUsername(), param.getPassword()));
        SecurityUser securityUser = (SecurityUser) authenticate.getPrincipal();
        String jwt = tokenService.sign(securityUser.getJwtPayload());
        UserLoginVo userLoginVo = new UserLoginVo();
        userLoginVo.setToken(jwt);
        return userLoginVo;
    }
}
