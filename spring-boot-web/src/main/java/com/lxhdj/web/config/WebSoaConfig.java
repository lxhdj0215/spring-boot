package com.lxhdj.web.config;

import com.lxhdj.web.interceptor.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 配置类
 * @author: wangguijun1
 * @create: 2019-11-26 10:41
 **/

@Configuration
public class WebSoaConfig implements WebMvcConfigurer {

    @Autowired
    private TestInterceptor testInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor).addPathPatterns("/**").excludePathPatterns("/");
    }
}
