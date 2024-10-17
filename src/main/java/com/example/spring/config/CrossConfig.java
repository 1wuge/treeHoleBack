package com.example.spring.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 设置一个全局跨域配置,这样Controller所有接口中就不需要@CrossOrigin注解了
 */
@Configuration
public class CrossConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                //Access-Control-Allow-Credentials允许跨域
                //是否允许cookie
                .allowCredentials(true)
                .maxAge(3600);
    }
}
