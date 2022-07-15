package com.javase;

import java.util.*;

/**
 * @description:
 */
public class GenericClass {
    public static void main(String[] args) {
        Person<String> person = new Person<>("张三");//String类型替换泛型T
        List<? super HashMap> list= new ArrayList<Map>();
        list.add(new LinkedHashMap());
    }
}

class Person<T> {
    T name;
    
    public Person(T name) {
        this.name = name;
    }
    
    public T say(T word) {
        return word;
    }
}