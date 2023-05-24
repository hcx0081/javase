package com.javase.set;

import java.util.HashSet;

/**
 * {@code @Description:}
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();
        Person p1 = new Person("AA", 10);
        Person p2 = new Person("BB", 11);
        hashSet.add(p1);
        hashSet.add(p2);
        
        p1.setName("CC");
        System.out.println(hashSet);
        
        hashSet.remove(p1);
        System.out.println(hashSet);
        
        Person p3 = new Person("CC", 10);
        hashSet.add(p3);
        System.out.println(hashSet);
        
        Person p4 = new Person("AA", 10);
        hashSet.add(p4);
        System.out.println(hashSet);
        /*
         * 没重写equals()和hashCode()时输出的是：
         * [Person{name='BB', age=11}, Person{name='CC', age=10}]
         * [Person{name='BB', age=11}]//内存地址相同，所以删除
         * [Person{name='CC', age=10}, Person{name='BB', age=11}]
         * [Person{name='CC', age=10}, Person{name='BB', age=11}, Person{name='AA', age=10}]
         *  */
        /*
         * 重写equals()和hashCode()后输出的是：
         * [Person{name='CC', age=10}, Person{name='BB', age=11}]
         * [Person{name='CC', age=10}, Person{name='BB', age=11}]// p1在集合中的存储位置并没有改变，修改属性name后的p1计算出来的hash值与存储在集合中的hash值不相同，所以没有删除
         * [Person{name='CC', age=10}, Person{name='BB', age=11}, Person{name='CC', age=10}]
         * [Person{name='CC', age=10}, Person{name='AA', age=10}, Person{name='BB', age=11}, Person{name='CC', age=10}]// p4计算出来的hash值与原来的p1相同，但是根据equals()判断为不相等的对象，所以可以添加
         *  */
    }
}