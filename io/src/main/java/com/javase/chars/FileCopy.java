package com.javase.chars;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * {@code @Description:}
 */
public class FileCopy {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("E:\\file.txt");
            fileWriter = new FileWriter("E:\\fileCopy.txt");
            
            // 定义字符缓冲区，每次从输入流中读取5个字符到该字符缓冲区
            char[] buffer = new char[5];
            int len;// 每次从输入流中读取到的字符个数
            while ((len = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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