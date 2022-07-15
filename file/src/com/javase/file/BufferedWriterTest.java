package com.javase.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description:
 */
public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("e:\\fileByBuffer.txt"));
        //这些字符首先会被写入缓冲区，当缓冲区写满或调用close()时，缓冲区中的字符才会被写入目标文件
        bufferedWriter.write("这是一个文件");
        bufferedWriter.close();
    }
}
