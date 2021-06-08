package com.lxhdj.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * @description: 配置类
 * @author: wangguijun1
 * @create: 2019-12-19 18:45
 **/

@Configuration
@EnableConfigurationProperties(InterceptorProperties.class)
public class WebAutoConfigure {

    @Autowired
    private InterceptorProperties interceptorProperties;

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter(new ObjectMapper());
    }

//    @Bean
//    public ObjectMapper jacksonObjectMapper() {
//        return new ObjectMapper();
//    }

    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames(interceptorProperties.getBeanNames());
        beanNameAutoProxyCreator.setInterceptorNames(interceptorProperties.getInterceptorNames());
        return beanNameAutoProxyCreator;
    }

}
