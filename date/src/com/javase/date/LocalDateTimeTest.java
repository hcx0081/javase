package com.javase.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * {@code @Description:}
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter yyy = DateTimeFormatter.ofPattern("yyyy");
        TemporalAccessor temporalAccessor = yyy.parse("2222");
        System.out.println(temporalAccessor);
        LocalDateTime localDateTime1 = localDateTime.plusYears(-1);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
    }
}