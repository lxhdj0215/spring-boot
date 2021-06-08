package com.lxhdj.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @description: 测试拦截器
 * @author: wangguijun1
 * @create: 2019-11-26 10:02
 **/

@Component
@Slf4j
public class TestInterceptor implements HandlerInterceptor, InitializingBean, DisposableBean {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            log.info("handlerMethod = " + handlerMethod.getMethod().getName());
//            log.info("annotations = " + JSON.toJSONString(handlerMethod.getMethod().getAnnotations()));
            Arrays.stream(handlerMethod.getMethod().getAnnotations()).forEach(annotation -> log.info(annotation.annotationType().getName()));
        }
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        log.info("TestInterceptor afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
//        log.info("TestInterceptor destroy");
    }
}
