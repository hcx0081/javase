package com.javase;

/**
 * @description:
 */
class Person<T> {
    T name;
    
    public Person(T name) {
        this.name = name;
    }
    
    public T say(T word) {
        return word;
    }
}

public class GenericClass {
    public static void main(String[] args) {
        Person<String> person = new Person<>("张三");// 具体类型String替换泛型T
    }
}