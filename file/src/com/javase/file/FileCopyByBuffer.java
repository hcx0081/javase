package com.javase.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description:
 */
public class FileCopyByBuffer {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("e:\\file.txt");
        FileOutputStream outputStream = new FileOutputStream("e:\\fileCopy.txt");
        //每次读取1024个字节存入该缓冲区
        byte[] buff = new byte[1024];
        int len;//存入读取到的字节数
        while ((len = inputStream.read(buff)) != -1) {
            outputStream.write(buff,0,len);
            System.out.print((char) len);
        }
        inputStream.close();
        outputStream.close();
    }
}
