package com.javase.reflection;

/**
 * @Description:
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Person> person1Class = Person.class;
        System.out.println(person1Class);// class com.javase.reflection.Person
        
        Class<?> person2Class = Class.forName("com.javase.reflection.Person");
        System.out.println(person2Class);// class com.javase.reflection.Person
        
        Person person = new Person();
        Class<? extends Person> person3Class = person.getClass();
        System.out.println(person3Class);// class com.javase.reflection.Person
    
        // 等同于：ClassLoader classLoader = Person.class.getClassLoader();
        ClassLoader classLoader = person.getClass().getClassLoader();
        Class<?> person4Class = classLoader.loadClass("com.javase.reflection.Person");
        System.out.println(person4Class);// class com.javase.reflection.Person
    }
}
