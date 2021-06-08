package com.lxhdj.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: aop拦截器配置文件
 * @author: wangguijun1
 * @create: 2019-12-19 18:37
 **/


@Data
@ConfigurationProperties("mti.base.aop")
public class InterceptorProperties {

    private String[] beanNames;

    private String[] interceptorNames;

}
