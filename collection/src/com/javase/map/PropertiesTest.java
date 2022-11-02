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
        FileInputStream fis = new FileInputStream("D:\\IDEA\\IntelliJ IDEA 2021.3.3\\Workspace\\javase\\collection\\src\\com\\javase\\resources\\jdbc.properties");
        properties.load(fis);
        properties.list(System.out);
        // -- listing properties --
        // user=root
        // password=123
        fis.close();
    
        FileOutputStream fos = new FileOutputStream("D:\\IDEA\\IntelliJ IDEA 2021.3.3\\Workspace\\javase\\collection\\src\\com\\javase\\resources\\jdbc.properties");
        properties.setProperty("url", "jdbc");
        properties.store(fos, null);
        fos.close();
    }
}
