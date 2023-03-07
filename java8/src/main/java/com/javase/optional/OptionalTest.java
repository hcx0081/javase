package com.javase.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * {@code @Description:}
 */
public class OptionalTest {
    @Test
    public void nullTest() {
        Person person = new Person();
        person = null;
        System.out.println(getPeronName1(person));
        System.out.println(getPeronName2(person));
    }
    
    /* 优化以前的方法，解决空指针 */
    String getPeronName1(Person person) {
        if (person != null) {
            return person.getName();
        }
        return null;
    }
    
    /* 优化以后的方法，解决空指针 */
    String getPeronName2(Person person) {
        Optional<Person> optional = Optional.ofNullable(person);
        return optional.orElse(new Person()).getName();
    }
}