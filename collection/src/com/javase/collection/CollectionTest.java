package com.javase.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * {@code @Description:}
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection list = new ArrayList();
        list.add(new String("1"));
        list.add(new String("2"));
        
        Collection list2 = new ArrayList();
        list2.add(new String("1"));
        
        System.out.println(list.containsAll(list2));
    }
}