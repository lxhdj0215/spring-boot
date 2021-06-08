package com.lxhdj.agent;

import java.io.IOException;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-12-27 20:45
 **/

public class Attacher {
    public static void main(String[] args) throws
            AttachNotSupportedException,
            IOException,
            AgentLoadException,
            AgentInitializationException {
        // 传入目标 JVM pid
        VirtualMachine vm = VirtualMachine.attach("9988");
        vm.loadAgent("D:/javassist-1.0-SNAPSHOT.jar");
    }
}
