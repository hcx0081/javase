package com.javase.collection;

import java.util.Random;
import java.util.Vector;

/**
 * {@code @Description:}
 */
public class SolutionByVector {
    public static void main(String[] args) {
        Vector<Integer> list = new Vector<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(new Random().nextInt(10));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}