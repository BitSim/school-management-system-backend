package com.hugcode.managementsystem.config;

import com.hugcode.managementsystem.interceptor.AdminInterceptor;
import com.hugcode.managementsystem.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/v1/**/login/**")
                .excludePathPatterns("/v3/api-docs")
                .excludePathPatterns("/api/v1/students/*/courses/*","/api/v1/students/*/condition","/api/v1/students/*/courses/condition",
                        "/api/v1/students/*/credits","/api/v1/students/*/courses/*","/api/v1/students/*","/api/v1/students");
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/api/v1/students/*/courses/*","/api/v1/students/*/condition","/api/v1/students/*/courses/condition",
                        "/api/v1/students/*/credits","/api/v1/students/*/courses/*","/api/v1/students/*","/api/v1/students")
                .excludePathPatterns("/api/v1/**/login/**")
                .excludePathPatterns("/v3/api-docs");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
//                .allowCredentials(true)
                .maxAge(3600);
    }
}
