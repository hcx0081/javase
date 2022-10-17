package com.javase.sort;

import java.util.Arrays;

/**
 * @Description:
 */
public class SelectionSort {
    static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[]{2, 3, 5, 4})));
    }
}
