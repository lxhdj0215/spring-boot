package com.lxhdj.algorithm;

import java.io.*;

/**
 * @description:单例
 * @author: wangguijun1
 * @create: 2020-01-09 17:44
 **/

public class Singleton implements Serializable {

    private static volatile Singleton singleton;

    private Singleton() {

    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    private Object readResolve() {
        return getSingleton();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton singleTon1 = Singleton.getSingleton();
        System.out.println("序列化攻击通过了吗？");
        File file = new File("serializable.txt");
        //序列化
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(singleTon1);
        oos.flush();
        oos.close();
        fos.close();
        //反序列化
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Singleton singleTon3 = (Singleton) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(singleTon1 == singleTon3); // true
    }

}
