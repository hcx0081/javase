package com.javase.transform;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @Description:
 */
public class OutputStreamWriterTest {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("e:\\file.txt"), "gbk");
        outputStreamWriter.write("你好呀");
        outputStreamWriter.close();
        //BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        //bufferedWriter.write("你好");
        //bufferedWriter.close();
    }
}
