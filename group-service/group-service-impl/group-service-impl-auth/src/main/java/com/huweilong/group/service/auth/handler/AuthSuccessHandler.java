package com.huweilong.group.service.auth.handler;

import com.alibaba.fastjson.JSONObject;
import com.huweilong.group.service.dto.basics.global.Results;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 认证成功 handler
 * @author Alex
 */
@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {
    /**
     * 认证成功业务处理
     * @param httpServletRequest httpServletRequest
     * @param httpServletResponse httpServletResponse
     * @param authentication 认证信息
     * @throws IOException 异常
     * @throws ServletException 异常
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(JSONObject.toJSONString(Results.SUCCESS(authentication)));
    }
}
