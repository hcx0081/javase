package com.javase.lambda;

/**
 * @Description:
 */
public class Person {
    private String name;
    
    public Person() {
        System.out.println("人");
    }
    
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
