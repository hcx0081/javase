package com.javase.map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Description:
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\IDEA\\IntelliJ IDEA 2021.3.3\\Workspace\\javase\\collection\\src\\com\\javase\\resources\\jdbc.properties"));
        properties.list(System.out);
        //-- listing properties --
        //user=root
        //password=123
        
        properties.setProperty("charset", "中文");
        properties.store(new FileOutputStream("D:\\IDEA\\IntelliJ IDEA 2021.3.3\\Workspace\\javase\\collection\\src\\com\\javase\\resources\\jdbc.properties"), "null");
    }
}
