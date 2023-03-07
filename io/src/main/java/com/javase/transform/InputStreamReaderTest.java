package com.javase.transform;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * {@code @Description:}
 */
public class InputStreamReaderTest {
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("E:\\file.txt"), "utf-8");
    
            // 定义字符缓冲区，每次从输入流中读取5个字符到该字符缓冲区
            char[] buffer = new char[5];
            int len;// 每次从输入流中读取到的字符个数
            while ((len = inputStreamReader.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}