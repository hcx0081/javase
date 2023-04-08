package com.javase.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * {@code @Description:}
 */
public class SolutionByCollections {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(list);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronizedList.add(new Random().nextInt(10));
                System.out.println(synchronizedList);
            }, String.valueOf(i)).start();
        }
    }
}