package com.javase.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description:
 */
public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.bilibili.com/");
        
        System.out.println(url.getPort());
    }
}
