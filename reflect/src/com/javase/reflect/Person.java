package com.javase.reflect;

/**
 * @Description:
 */
public class Person {
    
    public String name = "zs";
    
    public Person() {
    }
    
    public Person(String name) {
        this.name = name;
    }
    
    public void say() {
        System.out.println("hello");
    }
}
