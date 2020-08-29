package com.huweilong.group.service.auth.handler;

import com.alibaba.fastjson.JSONObject;
import com.huweilong.group.service.dto.basics.global.Results;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 认证失败 handler
 * @author Alex
 */
@Component
public class AuthFailureHandler implements AuthenticationFailureHandler {
    /**
     * 认证失败业务处理
     * @param httpServletRequest httpServletRequest
     * @param httpServletResponse httpServletResponse
     * @param e 认证失败信息
     * @throws IOException 异常
     * @throws ServletException 异常
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(JSONObject.toJSONString(Results.ERROR(e)));
    }
}
