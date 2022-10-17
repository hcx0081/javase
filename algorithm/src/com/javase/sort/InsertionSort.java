package com.javase.sort;

import java.util.Arrays;

/**
 * @Description:
 */
public class InsertionSort {
    static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{2, 3, 4, 1})));
    }
}
