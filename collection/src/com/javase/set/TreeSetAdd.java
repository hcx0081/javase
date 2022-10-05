package com.javase.set;

import java.util.TreeSet;

/**
 * @description:
 */
public class TreeSetAdd {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add("2");//[2]
        treeSet.add("1");//[1, 2]
        treeSet.add("4");//[1, 2, 4]
        treeSet.add("3");//[1, 2, 3, 4]
        
        System.out.println(treeSet);//[1, 2, 3, 4]
        
        TreeSet treeSet1 = new TreeSet();
        treeSet1.add("1");
        treeSet1.add("2");
        treeSet1.add("3");
        
        
    }
}
