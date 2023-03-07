package com.javase.date;

import java.time.Instant;

/**
 * {@code @Description:}
 */
public class InstantTest {
    public static void main(String[] args) {
        System.out.println(Instant.now());
        System.out.println(Instant.ofEpochMilli(System.currentTimeMillis()));
    }
}