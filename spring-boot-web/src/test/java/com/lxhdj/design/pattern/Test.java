package com.lxhdj.design.pattern;

import java.io.*;

/**
 * @description:
 * @author: wangguijun1
 * @create: 2020-09-01 20:59
 **/

public class Test {
    public static void main(String[] args) {
        File file = new File("D:\\1.txt");
        try {
            Reader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            StringBuffer buffer = new StringBuffer();
            while (line != null) {
                buffer.append(line);
                buffer.append(",");
                line = br.readLine();
            }
            System.out.println(buffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
