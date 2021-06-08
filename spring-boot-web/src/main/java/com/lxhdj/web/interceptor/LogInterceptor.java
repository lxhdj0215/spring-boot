package com.lxhdj.web.interceptor;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: 日志拦截器
 * @author: wangguijun1
 * @create: 2019-12-19 18:53
 **/

@Component
@Slf4j
public class LogInterceptor implements MethodInterceptor {

    private List<String> stringList;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String logRequest = getLogRequest(invocation);
        log.info(logRequest);

        Object object = invocation.proceed();

        String logResponse = getLogResponse(invocation, object);
        log.info(logResponse);
        return object;
    }


    private String getLogResponse(MethodInvocation invocation, Object object) {
        if (object == null) {
            return null;
        }
        String logHeader = getLogHeader(invocation);
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

    private String getLogRequest(MethodInvocation invocation) {
        String logHeader = getLogHeader(invocation);
        Object[] arguments = invocation.getArguments();

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

    private String getLogHeader(MethodInvocation invocation) {
        String simpleName = invocation.getThis().getClass().getSimpleName();
        String methodName = invocation.getMethod().getName();
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        buffer.append(simpleName);
        buffer.append(".");
        buffer.append(methodName);
        buffer.append("] ");
        return buffer.toString();
    }

}
