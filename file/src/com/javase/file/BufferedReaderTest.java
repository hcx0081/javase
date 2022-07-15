package com.javase.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description:
 */
public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("e:\\file.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        //关闭流，注意这里只需要关闭外层流BufferedReader，因为底层会自动区关闭节点流。
        bufferedReader.close();
    }
}
