package com.lxhdj.web.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-11-10 09:34
 **/

//@Component
@Aspect
@Slf4j
public class LogAspect {

    @Around("execution(* com.lxhdj.web.controller.*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object obj = null;
        try {
//            log.info("args===" + JSON.toJSONString(proceedingJoinPoint.getArgs()));
//            log.info("targetName===" + proceedingJoinPoint.getTarget().getClass().getName());
//            log.info("class name===" + proceedingJoinPoint.getThis().getClass().getName());
//            log.info("simple name===" + proceedingJoinPoint.getThis().getClass().getSimpleName());
//            log.info("========================" + proceedingJoinPoint.getSignature().getName());
//            log.info("start====================");

//            String logRequest = getLogRequest(proceedingJoinPoint);
//            log.info(logRequest);
            log.info("method：" + proceedingJoinPoint.getSignature().getName() + ", request：" + JSON.toJSONString(proceedingJoinPoint.getArgs()));
            obj = proceedingJoinPoint.proceed();
            log.info("method：" + proceedingJoinPoint.getSignature().getName() + ", response：" + obj);

//            String logResponse = getLogResponse(proceedingJoinPoint, obj);
//            log.info(logResponse);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return obj;
    }

    private String getLogResponse(ProceedingJoinPoint proceedingJoinPoint, Object object) {
        if (object == null) {
            return null;
        }
        String logHeader = getLogHeader(proceedingJoinPoint);
        StringBuffer buffer = new StringBuffer();
        buffer.append(logHeader);
        buffer.append("response = ");
        try {
            buffer.append(JSON.toJSONString(object));
        } catch (Exception e) {
            log.error(logHeader + " JSON 序列化失败", e);
            return null;
        }
        return buffer.toString();
    }

    private String getLogRequest(ProceedingJoinPoint invocation) {
        String logHeader = getLogHeader(invocation);
        Object[] arguments = invocation.getArgs();

        StringBuffer buffer = new StringBuffer();
        buffer.append(logHeader);
        buffer.append("request ");
        if (arguments.length == 0) {
            return buffer.toString() + " = { }";
        }
        int count = 1;
        for (Object argument : arguments) {
            buffer.append("var");
            buffer.append(count);
            buffer.append(" = ");
            try {
                buffer.append(JSON.toJSONString(argument));
            } catch (Exception e) {
//                LOG.error(logHeader + " JSON 序列化失败", e);
                return null;
            }
            buffer.append(" ");
            count++;
        }
        return buffer.toString();
    }

    private String getLogHeader(ProceedingJoinPoint invocation) {
        String simpleName = invocation.getTarget().getClass().getSimpleName();
        String methodName = invocation.getSignature().getName();
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        buffer.append(simpleName);
        buffer.append(".");
        buffer.append(methodName);
        buffer.append("] ");
        return buffer.toString();
    }
}
