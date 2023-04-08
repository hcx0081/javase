package com.javase.collection;

import java.util.ArrayList;
import java.util.Random;

/**
 * {@code @Description:} ${Description}
 */
public class CollectionSecurity {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(new Random().nextInt(10));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}