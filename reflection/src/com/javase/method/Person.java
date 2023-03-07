package com.javase.method;

public class Person {
    String name = "zs";
    int age = 20;
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}