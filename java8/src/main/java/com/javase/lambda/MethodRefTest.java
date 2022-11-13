package com.javase.lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Description:
 */
public class MethodRefTest {
    @Test
    public void test1() {
        /* Lambda表达式 */
        Consumer<String> consumer1 = str -> System.out.println(str);
        consumer1.accept("str");
        
        /* 对象::非静态方法名 */
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("str");
        
        PrintStream out = System.out;
        Consumer<String> consumer3 = out::println;
        consumer3.accept("str");
    }
    
    @Test
    public void test2() {
        /* Lambda表达式 */
        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        int i1 = comparator1.compare(1, 2);
        System.out.println(i1);
        
        /* 类::静态方法名 */
        Comparator<Integer> comparator2 = Integer::compare;
        int i2 = comparator2.compare(1, 2);
        System.out.println(i2);
    }
    
    @Test
    public void test3() {
        /* Lambda表达式 */
        Comparator<String> comparator1 = (str1, str2) -> str1.compareTo(str2);
        System.out.println(comparator1.compare("abc", "cba"));
        
        /* 类::非静态方法名 */
        Comparator<String> comparator2 = String::compareTo;
        System.out.println(comparator2.compare("abc", "cba"));
    }
}
