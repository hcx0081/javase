package com.javase;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code @Description:}
 */
public class GenericMethod {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3};
        System.out.println(Utils.copyArrayToList(arr));
    }
}

class Utils {
    static <T> List copyArrayToList(T[] arr) {
        List<T> list = new ArrayList<>();
        for (T t : arr) {
            list.add(t);
        }
        return list;
    }
}