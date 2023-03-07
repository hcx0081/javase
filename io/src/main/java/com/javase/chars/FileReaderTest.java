package com.javase.chars;

import java.io.FileReader;
import java.io.IOException;

/**
 * {@code @Description:}
 */
public class FileReaderTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("E:\\file.txt");
            
            int ch;// 每次从输入流中读取的字符
            while ((ch = fileReader.read()) != -1) {
                System.out.print((char) ch);
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