package com.javase.map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Description:
 */
public class PropertiesTest {
    public static void main(String[] args){
        Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("collection\\src\\com\\javase\\resources\\jdbc.properties");
            properties.load(fis);
            properties.list(System.out);
            // -- listing properties --
            // user=root
            // password=123
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("collection\\src\\com\\javase\\resources\\jdbc.properties");
            properties.setProperty("url", "jdbc");
            properties.store(fos, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
