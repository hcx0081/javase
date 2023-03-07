package com.javase.print;

import org.junit.Test;

import java.io.*;

/**
 * {@code @Description:}
 */
public class PrintStreamTest {
    
    @Test
    public void systemIn() {
        BufferedReader bufferedReader = null;
        try {
            InputStream in = System.in;
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            bufferedReader = new BufferedReader(inputStreamReader);
            System.out.println("请输入：");
            String data = bufferedReader.readLine();
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Test
    public void systemOut() {
        // 方式一
        PrintStream out = null;
        try {
            System.setOut(new PrintStream("E:\\file.txt"));// 输出到文件，默认是输出到控制台
            out = System.out;
            out.println("hello你好");// 底层调用write()
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (out != null) {
            out.close();
        }
        // 方式二
        try {
            System.setOut(new PrintStream("E:\\file.txt"));// 输出到文件，默认是输出到控制台
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("hello你好");// 底层调用write()
    }
}