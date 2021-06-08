package com.lxhdj.proxy.aop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @description: 切面拦截器
 * @author: wangguijun1
 * @create: 2019-11-29 16:06
 **/

public class AspectInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        List<Method> beforeMethods = getInterceptMethods(object.getClass().getSuperclass(), InterceptPoint.BEFORE);
        for (Method m : beforeMethods) {
            m.invoke(null, new Object[]{object, method, args});
        }
        try {
            Object result = methodProxy.invokeSuper(object, args);
            List<Method> afterMethods = getInterceptMethods(object.getClass().getSuperclass(), InterceptPoint.AFTER);
            for (Method m : afterMethods) {
                m.invoke(null, new Object[]{object, method, args, result});
            }
            return result;
        } catch (Exception e) {
            List<Method> exceptionMethods = getInterceptMethods(object.getClass().getSuperclass(), InterceptPoint.EXCEPTION);
            for (Method m : exceptionMethods) {
                m.invoke(null, new Object[]{object, method, args});
            }
            throw e;
        }
    }


    private static List<Method> getInterceptMethods(Class<?> cls, InterceptPoint interceptPoint) {
        Map<InterceptPoint, List<Method>> map = CGLibContainer.getInterceptMethodMap().get(cls);
        if (map == null) {
            return Collections.emptyList();
        }
        List<Method> methods = map.get(interceptPoint);
        if (methods == null) {
            return Collections.emptyList();
        }
        return methods;
    }
}
