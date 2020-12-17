package com.asktao.web.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author wcy
 */
@Component
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    private ThreadLocal<StopWatch> swThread = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        StopWatch sw = new StopWatch();
        swThread.set(sw);
        sw.start();
        MDC.clear();
        MDC.put("threadId", UUID.randomUUID().toString().replaceAll("-", ""));

        log.info("请求路径: {}, Authorization = {}", request.getRequestURI(), request.getHeader("Authorization"));
        requestDebugLog(request);
        return true;
    }

    private void requestDebugLog(HttpServletRequest request) {
        if (log.isDebugEnabled()) {
            // request body 参数获取
            Map<String, String> body = new HashMap<>(16);
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String name = parameterNames.nextElement();
                body.put(name, request.getParameter(name));
            }
            log.info("body: {}", body);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        swThread.get().stop();
        swThread.get().start();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        StopWatch sw = swThread.get();
        sw.stop();
        String method = handler.getClass().getSimpleName();
        if (handler instanceof HandlerMethod) {
            String beanType = ((HandlerMethod) handler).getBeanType().getName();
            String methodName = ((HandlerMethod) handler).getMethod().getName();
            method = beanType + "." + methodName;
        }

        log.info("METHOD = {}; STATUS = {}; EX = {}; 总时间 = {}ms; 完成时间 = {}ms; 前置时间 = {}ms",
                method,
                response.getStatus(),
                ex == null ? "-" : ex.getClass().getSimpleName(),
                sw.getTotalTimeMillis(),
                sw.getTotalTimeMillis() - sw.getLastTaskTimeMillis(),
                sw.getLastTaskTimeMillis());
        swThread.remove();
    }
}