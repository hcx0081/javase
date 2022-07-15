package com.javase.bytes;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description:
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("e:\\file.txt");
        int len;
        //byte[] bytes = new byte[8];
        while ((len = fileInputStream.read()) != -1) {
            System.out.print((char) len);//hello
            //System.out.println(new String(bytes,0,len));
        }
        fileInputStream.close();
    }
}
