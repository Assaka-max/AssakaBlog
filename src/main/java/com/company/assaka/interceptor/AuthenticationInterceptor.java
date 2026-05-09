package com.company.assaka.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty()){
            response.setStatus(401);
            response.getWriter().write("{\"code\":401, \"message\":\"未携带身份凭证\"}");
            return false;
        }
        request.setAttribute("token", token);
        return true;
    }
}
