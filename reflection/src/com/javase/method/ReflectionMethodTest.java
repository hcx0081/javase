package com.javase.method;

import java.lang.reflect.Field;

/**
 * {@code @Description:}
 */
public class ReflectionMethodTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> cls = Class.forName("com.javase.method.Person");
        System.out.println(cls);// class com.javase.method.Person
        
        System.out.println(cls.getName());// com.javase.method.Person
        System.out.println(cls.getClass().getName());// java.lang.Class
        System.out.println(cls.getPackage().getName());// com.javase.method
        
        Object person = cls.newInstance();
        System.out.println(person);// Person{name='zs', age=20}
        System.out.println(person.getClass());// class com.javase.method.Person
        
        Field name = cls.getDeclaredField("name");
        System.out.println(name.get(person));// zs
        name.set(person, "ls");
        System.out.println(name.get(person));// ls
        Class<Integer> type = Integer.TYPE;
    }
}