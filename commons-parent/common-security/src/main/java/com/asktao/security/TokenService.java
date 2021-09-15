package com.asktao.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author wuyang
 */
@Slf4j
@Component
public class TokenService {
    public boolean canAccess(HttpServletRequest request, Authentication authentication) {
        // TODO: 2021/9/14 暂不实现ROLE相关鉴权逻辑
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (log.isDebugEnabled()) {
            log.debug("{}", authorities);
        }
        return true;
    }
}
