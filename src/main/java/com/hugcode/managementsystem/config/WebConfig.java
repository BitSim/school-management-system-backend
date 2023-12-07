package com.hugcode.managementsystem.config;

import com.hugcode.managementsystem.interceptor.JWTInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    /***
     * addPathPatterns("/**"):拦截所有请求
     * excludePathPatterns： 不拦截的请求
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry){
        //注册拦截器要声明拦截器对象和要拦截的请求
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/v1/**/login/**")
                .excludePathPatterns("/v3/api-docs");
    }


}
