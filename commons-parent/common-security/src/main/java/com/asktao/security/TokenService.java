package com.asktao.security;

import com.asktao.lib.dto.JwtPayload;
import com.asktao.lib.ex.BizException;
import com.asktao.lib.ex.CodeEnum;
import com.asktao.lib.ex.SysException;
import com.asktao.lib.util.JsonUtils;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Collection;

/**
 * @author wuyang
 */
@Slf4j
@Component
public class TokenService {
    public static final String JWT_TOKEN_PREFIX = "Bearer ";

    @Autowired
    private RSAKey rsaKey;

    public boolean canAccess(HttpServletRequest request, Authentication authentication) {
        // TODO: 2021/9/14 暂不实现ROLE相关鉴权逻辑
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (log.isDebugEnabled()) {
            log.debug("{}", authorities);
        }
        String realToken = getHeaderToken(request);
        if (StringUtils.isBlank(realToken)) {
            return false;
        }
        verifierToken(getJwsObject(realToken));
        return true;
    }

    /**
     * 解析jwt，获取Payload内容
     */
    public JwtPayload getPayload(HttpServletRequest request) {
        String realToken = getHeaderToken(request);
        if (StringUtils.isBlank(realToken)) {
            return null;
        }
        JWSObject jwsObject = getJwsObject(realToken);
        String payloadStr = jwsObject.getPayload().toString();
        return JsonUtils.fromJson(payloadStr, JwtPayload.class);
    }

    private JWSObject getJwsObject(String realToken) {
        JWSObject jwsObject = null;
        try {
            jwsObject = JWSObject.parse(realToken);
        } catch (ParseException e) {
            log.warn("jwt parse error:{}", e.getMessage());
            if (log.isErrorEnabled()) {
                log.error("jwt parse errorStack:", e);
            }
            throw new BizException(CodeEnum.UNAUTHORIZED);
        }
        return jwsObject;
    }

    private void verifierToken(JWSObject jwsObject) {
        try {
            RSASSAVerifier verifier = new RSASSAVerifier(rsaKey);
            boolean verify = jwsObject.verify(verifier);
            if (!verify) {
                log.error("令牌验签不通过: {}", verifier);
                throw new BizException(CodeEnum.UNAUTHORIZED);
            }
        } catch (JOSEException e) {
            log.warn("jwt verifier error:{}", e.getMessage());
            if (log.isErrorEnabled()) {
                log.error("jwt verifier errorStack:", e);
            }
            throw new BizException(CodeEnum.UNAUTHORIZED);
        }
    }

    private String getHeaderToken(HttpServletRequest request) {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isNotBlank(authorization)) {
            return authorization.replace(JWT_TOKEN_PREFIX, "");
        }
        return authorization;
    }
}
