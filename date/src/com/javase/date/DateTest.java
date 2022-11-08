package com.javase.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 */
public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss E");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
        
    }
}
