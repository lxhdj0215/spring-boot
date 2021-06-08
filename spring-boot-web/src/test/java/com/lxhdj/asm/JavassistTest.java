package com.lxhdj.asm;

import org.apache.ibatis.javassist.*;

import java.io.IOException;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-12-27 19:56
 **/

public class JavassistTest {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        Base b = new Base();
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.lxhdj.asm.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile("javassist");
        Base h = (Base) c.newInstance();
        h.process();
    }
}
