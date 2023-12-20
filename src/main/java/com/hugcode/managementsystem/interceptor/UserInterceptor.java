package com.hugcode.managementsystem.interceptor;

import com.hugcode.managementsystem.common.AppException;
import com.hugcode.managementsystem.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;


public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Enumeration<String> headerNames = request.getHeaderNames();
//        System.out.println("Method： " + request.getMethod());
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            String headerValue = request.getHeader(headerName);
//            System.out.println("Header: " + headerName + " = " + headerValue);
//        }

        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        String token = request.getHeader("Authorization");
        Claims claims=JwtUtil.parseJWT(token);
        System.out.println(claims);
        try {
            if (token == null || claims==null) {
                throw new AppException(401, "请先登录");
            }
            if(!claims.get("typ").equals("admin")&&!claims.get("typ").equals("user")){
                throw new AppException(401,"权限不够");
            }

        } catch (io.jsonwebtoken.security.SignatureException e) {
            // 处理JWT签名验证失败的情况
            // 可以记录日志、返回特定的错误响应等
            System.err.println("JWT签名验证失败：" + e.getMessage());
            throw new AppException(401, "JWT签名验证失败");
        }

        return true;
    }

}