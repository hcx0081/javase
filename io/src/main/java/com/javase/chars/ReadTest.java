package com.javase.chars;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Description:
 */
public class ReadTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("E:\\read.txt");
            
            // 定义字符缓冲区，每次从输入流中读取5个字符到该字符缓冲区
            char[] buffer = new char[5];
            int len;// 每次从输入流中读取到的字符个数
            while ((len = fileReader.read(buffer)) != -1) {
                /* 错误的写法 */
                // for (int i = 0; i < buffer.length; i++) {
                //     System.out.print(buffer[i]);// helloworld123ld
                // }
                // System.out.print(new String(buffer));// helloworld123ld
                /* 正确的写法 */
                // for (int i = 0; i < len; i++) {
                //     System.out.print(buffer[i]);// helloworld123
                // }
                System.out.print(new String(buffer, 0, len));// helloworld123
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
