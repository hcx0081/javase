package com.javase.sort;

import java.util.Arrays;

/**
 * @Description:
 */
public class BubbleSort {
    static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{4, 3, 2, 1})));
    }
}
