package com.javase.compare;

import java.util.Arrays;

/**
 * {@code @Description:}
 */
public class ComparableTest {
    public static void main(String[] args) {
        Person person1 = new Person("zs", 20);
        Person person2 = new Person("ls", 21);
        Person person3 = new Person("ww", 22);
        Person person4 = new Person("ab", 22);
        Person[] personList = {person1, person2, person3, person4};
        // Person默认不可以进行比较排序，会抛出ClassCastException异常
        Arrays.sort(personList);
        System.out.println(Arrays.toString(personList));
    }
}