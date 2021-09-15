package com.asktao.security.handler;

import com.asktao.lib.dto.Response;
import com.asktao.lib.ex.CodeEnum;
import com.asktao.lib.util.JsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * {@code @tokenService.canAccess(request, authentication)}返回false后，进入此逻辑，返回错误信息
 *
 * @author wuyang
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        Response response = Response.buildFailure(CodeEnum.ACCESS_REJECT.code(), CodeEnum.ACCESS_REJECT.msg());
        httpServletResponse.setStatus(HttpStatus.OK.value());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
        httpServletResponse.getWriter().println(JsonUtils.toJson(response));
    }
}
