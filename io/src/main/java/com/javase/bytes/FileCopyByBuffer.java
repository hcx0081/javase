package com.javase.bytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * {@code @Description:}
 */
public class FileCopyByBuffer {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("E:\\file.mp4");
            outputStream = new FileOutputStream("E:\\fileCopy.mp4");
            
            // 定义字节缓冲区，每次从输入流中读取1024个字节到该字节缓冲区
            byte[] buffer = new byte[1024];
            int len;// 每次从输入流中读取到的字节个数
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);// 1024：10903
    }
}