package com.javase.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;

/**
 * {@code @Description:}
 */
public class ArrayRefTest {
    @Test
    public void test() {
        // Function<T, R>
        // R apply(T t)
        
        /* Lambda表达式 */
        Function<Integer, String[]> function1 = length -> new String[length];
        System.out.println(Arrays.toString(function1.apply(10)));
        
        /* 数组引用 */
        Function<Integer, String[]> function2 = String[]::new;
        System.out.println(Arrays.toString(function2.apply(10)));
    }
}