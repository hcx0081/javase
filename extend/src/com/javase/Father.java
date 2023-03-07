package com.javase;

/**
 * {@code @Description:}
 */
public class Father {
    String name;
    int age;
    
    
    public Father(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void say() {
        System.out.println(this.name + "hello");
    }
}

class Son extends Father {
    
    public Son(String name, int age) {
        super(name, age);
    }
    
    public static void main(String[] args) {
        Son son = new Son("zs", 20);
        son.say();
    }
}