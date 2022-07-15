package com.javase.singleton;

/**
 * @description: 饿汉式
 */
public class hunger {
    public static void main(String[] args) {
        Person person1 = Person.getInstance();
        System.out.println(person1);
        Person person2 = Person.getInstance();
        System.out.println(person2==person1);
        //构造器
        //Person{name='zs'}
        //true
    }
}

class Person {
    private static Person instance = new Person("zs");
    private String name;
    
    private  Person(String name) {
        System.out.println("构造器");
        this.name = name;
    }
    
    public static Person getInstance() {
        return instance;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}