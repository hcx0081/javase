package com.javase.sort;

import java.util.Arrays;

/**
 * @Description:
 */
public class ShellSort {
    static int[] shellSort(int[] arr) {
        int step;
        for (step = arr.length / 2; step > 0; step = (step - 1) / 2) {
            for (int i = step; i < arr.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (arr[j] < arr[j - 1]) {
                        int temp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shellSort(new int[]{2, 3, 4, 1})));
    }
}
