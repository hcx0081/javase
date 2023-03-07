package com.javase.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * {@code @Description:}
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("2");// [2]
        treeSet.add("1");// [1, 2]
        treeSet.add("4");// [1, 2, 4]
        treeSet.add("3");// [1, 2, 3, 4]
        
        System.out.println(treeSet);// [1, 2, 3, 4]
        
        
        Comparator<Person> comparator=new Comparator<Person>() {
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
        };
        TreeSet<Person> personList = new TreeSet<>(comparator);
        personList.add(new Person("zs", 20));
        personList.add(new Person("ls", 21));
        personList.add(new Person("ww", 22));
        personList.add(new Person("ab", 22));
        System.out.println(personList);
    }
}