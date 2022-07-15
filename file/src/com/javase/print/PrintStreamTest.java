package com.javase.print;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @Description:
 */
public class PrintStreamTest {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        /*可以修改打印流的写入的位置*/
        //System.setOut(new PrintStream("e:\\file.txt"));//输出到文件
        //System.setOut(System.out);//输出到显示器，默认
        out.println("hello");//底层是调用write()
        out.write("hello".getBytes());
        //hello
        //hello
        System.out.println("hello");
        out.close();
    }
}
