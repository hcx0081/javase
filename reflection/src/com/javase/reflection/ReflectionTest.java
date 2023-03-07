package com.javase.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * {@code @Description:}
 */
public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        /* 传统方式 */
        // Person personArgs = new Person();
        // personArgs.say();
        
        
        /* 反射方式 */
        // 加载类
        Class<?> clazz = Person.class;// 等同于：Class.forName("com.javase.reflection.Person")
        
        // 通过加载的类调用无参构造器返回类的实例
        Object personNoArgs = clazz.newInstance();
        System.out.println(personNoArgs.getClass());// class com.javase.reflection.Person
        System.out.println(personNoArgs);// Person{name='null', age=0}
        
        // 通过加载的类调用有参构造器返回类的实例
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        Object personArgs = constructor.newInstance("zs", 20);
        System.out.println(personArgs.getClass());// class com.javase.reflection.Person
        System.out.println(personArgs);// Person{name='zs', age=20}
        
        
        Field name = clazz.getField("name");
        // 通过字段对象实现设置属性
        name.set(personNoArgs, "ls");
        System.out.println(personNoArgs);// Person{name='ls', age=0}
        
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);// 禁用访问安全检查，可以访问私有的属性
        age.set(personNoArgs, 20);
        System.out.println(personNoArgs);// Person{name='ls', age=20}
        
        
        Method say = clazz.getMethod("say");
        // 通过方法对象实现调用方法
        // 传统方式：对象.方法()
        // 反射方式：方法对象.invoke(对象)
        Object invoke = say.invoke(personNoArgs);// hello
        System.out.println(invoke);// 返回值：null
    }
}