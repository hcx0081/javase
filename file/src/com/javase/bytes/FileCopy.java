package com.javase.bytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description:
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("e:\\file.txt");
        FileOutputStream outputStream = new FileOutputStream("e:\\fileCopy.txt");
        int len;//存入每次读取的一个字节
        while ((len = inputStream.read()) != -1) {
            outputStream.write(len);
            System.out.print((char) len);
        }
        inputStream.close();
        outputStream.close();
    }
}
