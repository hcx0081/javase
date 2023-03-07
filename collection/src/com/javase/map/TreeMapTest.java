package com.javase.map;

import java.util.TreeMap;

/**
 * {@code @Description:}
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("100", new Person("zs", 10));
        treeMap.put("101", new Person("ls", 11));
        treeMap.put(new Person("zs", 10), "100");
        treeMap.put(new Person("ls", 11), "101");
        System.out.println(treeMap);
    }
}