package com.company.assaka.config;

import com.company.assaka.interceptor.AuthInterceptor;
import com.company.assaka.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private AuthInterceptor authInterceptor;

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/auth/visitor");

        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/api/auth/**", "/api/blog/**")               // 拦截所有 /api 下的请求
                .excludePathPatterns(                     // 放行以下几个接口
                        "/api/auth/visitor",
                        "/api/auth/login",
                        "/api/blog/all"
                );
    }
}
