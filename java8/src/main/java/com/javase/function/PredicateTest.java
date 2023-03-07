package com.javase.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * {@code @Description:}
 */
public class PredicateTest {
    @Test
    public void PredicateTest() {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        
        // String result = find(list, "张三");
        // System.out.println(result);
        
        /* Java 8 */
        // String result = findByPredicate(list, new Predicate<String>() {
        //     @Override
        //     public boolean test(String name) {
        //         return "张三".equals(name);
        //     }
        // });
        // System.out.println(result);
        
        
        String result = findByPredicate(list, name -> "张三".equals(name));
        System.out.println(result);
    }
    
    String find(List<String> nameList, String name) {
        for (String s : nameList) {
            if (name.equals(s)) {
                return name;
            }
        }
        return "未找到";
    }
    
    String findByPredicate(List<String> nameList, Predicate<String> predicate) {
        for (String name : nameList) {
            if (predicate.test(name)) {
                return name;
            }
        }
        return "未找到";
    }
}