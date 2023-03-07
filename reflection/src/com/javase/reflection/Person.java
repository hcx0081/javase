package com.javase.reflection;

/**
 * {@code @Description:}
 */
public class Person {
    public String name;
    private int age;
    
    public Person() {
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void say() {
        System.out.println("hello");
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}