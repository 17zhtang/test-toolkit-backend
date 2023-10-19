package com.hltn.test.config;

import com.hltn.test.interceptors.LoginProtectedInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Autowired
    private LoginProtectedInterceptor loginProtectedInterceptor;

    //跨域配置addCorsMappings  允许所有请求跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //是否发送Cookie
                .allowCredentials(true)
                //放行哪些原始域
                .allowedOriginPatterns("*")
                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
                .allowedHeaders("*")
                .exposedHeaders("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置请求拦截器拦截和不拦截的路径
//        registry.addInterceptor(loginProtectedInterceptor).addPathPatterns("/**")
        registry.addInterceptor(loginProtectedInterceptor).addPathPatterns("/device/**")
        .excludePathPatterns("/user/login")
        .excludePathPatterns("/user/register");
    }



}