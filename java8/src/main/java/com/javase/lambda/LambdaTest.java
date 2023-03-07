package com.javase.lambda;

import java.util.Comparator;

/**
 * {@code @Description:}
 */
public class LambdaTest {
    public static void main(String[] args) {
        /* 传统写法 */
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int i1 = comparator1.compare(1, 2);
        System.out.println(i1);
        
        /* Lambda表达式 */
        Comparator<Integer> comparator2 = (o1, o2) -> Integer.compare(o1, o2);
        int i2 = comparator2.compare(1, 2);
        System.out.println(i2);
        
        /* 方法引用 */
        Comparator<Integer> comparator3 = Integer::compare;
        int i3 = comparator3.compare(1, 2);
        System.out.println(i3);
    }
}