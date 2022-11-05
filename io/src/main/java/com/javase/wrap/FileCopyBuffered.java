package com.javase.wrap;

import org.junit.Test;

import java.io.*;

/**
 * @Description:
 */
public class FileCopyBuffered {
    @Test
    public void FileCopyByByte() {
        long begin = System.currentTimeMillis();
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("E:\\file.mp4"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("E:\\fileCopy.mp4"));
            
            // 定义字节缓冲区，每次从输入流中读取8192个字节到该字节缓冲区
            byte[] buffer = new byte[2048];
            int len;// 每次从输入流中读取到的字节/每次从输入流中读取到的字节个数
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                // bufferedOutputStream.write(len);
                bufferedOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);// 1：17128  5：6342  1024：3268   8192：1740
    }
    
    @Test
    public void FileCopyByChar() {
        long begin = System.currentTimeMillis();
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("E:\\file.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("E:\\fileCopy.txt"));
            
            // 定义字符缓冲区，每次从输入流中读取8192个字符到该字符缓冲区
            /* char[] buffer = new char[2048];
            int len;// 每次从输入流中读取到的字符/每次从输入流中读取到的字符个数
            while ((len = bufferedReader.read(buffer)) != -1) {
                // bufferedWriter.write(len);
                bufferedWriter.write(buffer, 0, len);
            } */
    
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
