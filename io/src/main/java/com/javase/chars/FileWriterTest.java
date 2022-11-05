package com.javase.chars;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description:
 */
public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("E:\\file.txt");
            
            char[] buffer = {'a', 98, 'c'};
            System.out.println(buffer);// abc
            fileWriter.write(buffer);
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
        }
    }
}
