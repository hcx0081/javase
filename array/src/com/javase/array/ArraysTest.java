package com.javase.array;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 */
public class ArraysTest {
    static int[] arr1;
    static int[] arr2;
    
    public static void main(String[] args) {
        System.out.println(Arrays.equals(arr1, arr2));
        
        List<int[]> ints = Arrays.asList(new int[]{1, 2});
        List<Integer> integers = Arrays.asList(new Integer[]{1, 2});// List<Integer> integers = Arrays.asList(1, 2);
        List<String> strings = Arrays.asList(new String[]{"1", "2"});// List<String> strings = Arrays.asList("1", "2");
        System.out.println(ints.size());// 1
        System.out.println(integers.size());// 2
        System.out.println(strings.size());// 2
        
        int[] arr = {1, 2, 3, 4};
        System.out.println(arr);
        arr = Arrays.copyOf(arr, 10);
        System.out.println(arr);
    }
}
