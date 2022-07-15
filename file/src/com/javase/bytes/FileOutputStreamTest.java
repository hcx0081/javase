package com.javase.bytes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 */
public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        String path = "e:\\file.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        String str = "hello";
        fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
        fileOutputStream.close();
    }
}
