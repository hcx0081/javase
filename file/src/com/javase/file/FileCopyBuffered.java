package com.javase.file;

import java.io.*;

/**
 * @Description:
 */
public class FileCopyBuffered {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("e:\\fileBuffered.txt"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("e:\\fileBufferedCopy.txt"));
        int len;//存入读取到的字节数
        while ((len = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(len);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
