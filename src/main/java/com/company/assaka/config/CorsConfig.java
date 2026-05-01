package com.company.assaka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        // 1. 创建 CORS 配置对象
        CorsConfiguration config = new CorsConfiguration();

        // 2. 傻瓜式放行配置（仅限本地开发阶段使用！）
        config.addAllowedOriginPattern("*");  // 允许任何前端域名访问
        config.addAllowedHeader("*");         // 允许任何请求头（比如我们的 Token 请求头）
        config.addAllowedMethod("*");         // 允许任何请求方式（GET, POST, PUT, DELETE 等）
        config.setAllowCredentials(true);     // 【极其重要】允许携带 Cookie / 凭证信息

        // 3. 把配置应用到所有接口路径
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        // 4. 返回跨域过滤器
        return new CorsFilter(source);
    }
}
