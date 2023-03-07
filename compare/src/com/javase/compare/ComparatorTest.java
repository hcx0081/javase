package com.javase.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * {@code @Description:}
 */
public class ComparatorTest {
    public static void main(String[] args) {
        Person person1 = new Person("zs", 20);
        Person person2 = new Person("ls", 21);
        Person person3 = new Person("ww", 22);
        Person person4 = new Person("ab", 22);
        Person[] personList = {person1, person2, person3, person4};
        // Person默认不可以进行比较排序，会抛出ClassCastException异常
        Arrays.sort(personList, new Comparator<Person>() {
            // 指定Person的排序方式：先按照年龄从低到高进行排序，再按照姓名从低到高进行排序
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getAge() > o2.getAge()) {
                    return 1;
                }
                if (o1.getAge() < o2.getAge()) {
                    return -1;
                }
                // return 0// 不排序姓名
                return o1.getName().compareTo(o2.getName());// 排序姓名
            }
        });
        System.out.println(Arrays.toString(personList));
    }
}