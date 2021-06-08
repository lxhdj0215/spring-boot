package com.lxhdj.proxy.aop;

import com.lxhdj.proxy.annotation.SimpleInject;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2019-11-29 10:32
 **/

public class CGLibContainer {

    private static Map<Class<?>, Map<InterceptPoint, List<Method>>> interceptMethodMap = new HashMap<>();

    private static Class<?>[] aspects = new Class<?>[]{ServiceLogAspect.class, ExceptionAspect.class};

    static {
        init();
    }

    private static void init() {
        for (Class<?> cls : aspects) {
            Aspect aspect = cls.getAnnotation(Aspect.class);
            if (aspect == null) {
                continue;
            }
            Method before = getMethod(cls, "before", new Class<?>[]{Object.class, Method.class, Object[].class});
            Method after = getMethod(cls, "after", new Class<?>[]{Object.class, Method.class, Object[].class, Object.class});
            Method exception = getMethod(cls, "exception", new Class<?>[]{Object.class, Method.class, Object[].class});

            Class<?>[] interceptedArr = aspect.value();
            for (Class<?> intercepted : interceptedArr) {
                addInterceptMethod(intercepted, InterceptPoint.BEFORE, before);
                addInterceptMethod(intercepted, InterceptPoint.AFTER, after);
                addInterceptMethod(intercepted, InterceptPoint.EXCEPTION, exception);
            }
        }
    }

    private static void addInterceptMethod(Class<?> cls, InterceptPoint interceptPoint, Method method) {
        if (method == null) {
            return;
        }
        Map<InterceptPoint, List<Method>> map = interceptMethodMap.get(cls);
        if (map == null) {
            map = new HashMap<>();
            interceptMethodMap.put(cls, map);
        }
        List<Method> methods = map.get(interceptPoint);
        if (methods == null) {
            methods = new ArrayList<>();
            map.put(interceptPoint, methods);
        }
        methods.add(method);
    }

    private static Method getMethod(Class<?> cls, String name, Class<?>[] paramTypes) {
        try {
            return cls.getMethod(name, paramTypes);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static <T> T getInstance(Class<T> cls) {
        try {
            T obj = createInstance(cls);
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(SimpleInject.class)) {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    Class<?> fieldCls = field.getType();
                    field.set(obj, getInstance(fieldCls));
                }
            }
            return obj;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static <T> T createInstance(Class<T> cls) throws IllegalAccessException, InstantiationException {
        if (!interceptMethodMap.containsKey(cls)) {
            return cls.newInstance();
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new AspectInterceptor());
        return (T) enhancer.create();
    }


    public static Map<Class<?>, Map<InterceptPoint, List<Method>>> getInterceptMethodMap() {
        return interceptMethodMap;
    }

    public static void setInterceptMethodMap(Map<Class<?>, Map<InterceptPoint, List<Method>>> interceptMethodMap) {
        CGLibContainer.interceptMethodMap = interceptMethodMap;
    }

    public static Class<?>[] getAspects() {
        return aspects;
    }

    public static void setAspects(Class<?>[] aspects) {
        CGLibContainer.aspects = aspects;
    }
}
