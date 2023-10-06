package com.hltn.test.config;

import com.hltn.test.interceptors.LoginProtectedInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Autowired
    private LoginProtectedInterceptor loginProtectedInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置请求拦截器拦截和不拦截的路径
//        registry.addInterceptor(loginProtectedInterceptor).addPathPatterns("/**")
        registry.addInterceptor(loginProtectedInterceptor).addPathPatterns("/device/**")
        .excludePathPatterns("/user/login")
        .excludePathPatterns("/user/register");
    }
}