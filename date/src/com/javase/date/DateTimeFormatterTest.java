package com.javase.date;

import java.time.format.DateTimeFormatter;

/**
 * @Description:
 */
public class DateTimeFormatterTest {
    public static void main(String[] args) {
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.parse("2000-08-01"));
        System.out.println(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
