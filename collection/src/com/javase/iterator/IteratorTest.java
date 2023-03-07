package com.javase.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * {@code @Description:}
 */
public class IteratorTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj.equals(1)) {
                iterator.remove();
            }
            System.out.println(obj);
            // 1
            // 2
            // 3
        }
        Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            Object obj = iterator2.next();
            System.out.println(obj);
            // 2
            // 3
        }
    }
}