package com.javase.transform;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description:
 */
public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("e:\\file.txt"), "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        if ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
