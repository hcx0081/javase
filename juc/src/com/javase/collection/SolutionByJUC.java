package com.javase.collection;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * {@code @Description:}
 */
public class SolutionByJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(new Random().nextInt(10));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}