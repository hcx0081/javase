package com.javase.prop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description:
 */
public class PropTest {
    public static void main(String[] args) throws IOException {
        // FileInputStream is = new FileInputStream("reflection/src/com/javase/person.properties");// 相对路径的根路径为主模块
        InputStream is = PropTest.class.getClassLoader().getResourceAsStream("com/javase/person.properties");// 相对路径的根路径为当前模块的源根
        
        Properties properties = new Properties();
        properties.load(is);
        String fullClass = properties.getProperty("fullClass");
        System.out.println(fullClass);
    }
}
