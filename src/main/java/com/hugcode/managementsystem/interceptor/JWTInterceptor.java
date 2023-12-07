package com.hugcode.managementsystem.interceptor;

import com.hugcode.managementsystem.util.JwtUtil;
import com.hugcode.managementsystem.common.AppException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;



public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null || JwtUtil.parseJWT(token)==null) {
            throw new AppException(401, "无效的token");
        }
        return true;
    }
}