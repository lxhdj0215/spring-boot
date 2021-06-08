package com.lxhdj.io.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2021-01-31 20:15
 **/

public class IOClient {
    public static void main(String[] args) {
        // TODO 创建多个线程，模拟多个客户端连接服务端
        Runnable runnable1 = () -> System.out.println("Hello World");

        Runnable runnable = () -> {
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                while (true) {
                    try {
                        socket.getOutputStream().write((Thread.currentThread().getId() + "：" + new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }
}
