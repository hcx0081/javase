package com.javase.lambda;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Description:
 */
public class ConstructorRefTest {
    @Test
    public void test() {
        // Supplier<T>
        // T get()
        
        // Function<T, R>
        // R apply(T t)
        
        /* Lambda表达式 */
        Supplier<Person> supplier1 = () -> new Person();
        System.out.println(supplier1.get());
        
        Function<String, Person> function1 = name -> new Person(name);
        System.out.println(function1.apply("张三"));
        
        
        /* 构造器引用 */
        Supplier<Person> supplier2 = Person::new;
        System.out.println(supplier2.get());
        
        Function<String, Person> function2 = Person::new;
        System.out.println(function2.apply("张三"));
    }
}
