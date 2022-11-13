package com.javase.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @Description:
 */
public class TerminalOpTest {
    List<String> list = new ArrayList<>();
    
    @Test
    public void matchTest() {
        list.add("张三");
        list.add("李四");
        list.add("王五");
        
        // 判断集合中是否所有元素都是张三
        System.out.println(list.stream().allMatch("张三"::equals));// false
        // 判断集合中是否有元素是张三
        System.out.println(list.stream().anyMatch("张三"::equals));// true
        // 判断集合中是否没有元素是张三
        System.out.println(list.stream().noneMatch("张三"::equals));// false
    }
    
    @Test
    public void findTest() {
        list.add("张三");
        list.add("李四");
        list.add("王五");
        
        // 返回该集合中第一个元素
        System.out.println(list.stream().findFirst().get());
        // 返回该集合中任意一个元素
        System.out.println(list.parallelStream().findAny().get());
    }
    
    @Test
    public void CountMaxMinTest() {
        list.add("aa");
        list.add("bb");
        list.add("cc");
        
        // 返回该集合中的元素个数
        System.out.println(list.stream().count());
        // 返回该集合中最大的元素
        System.out.println(list.stream().max(String::compareTo).get());
        // 返回该集合中最小的元素
        System.out.println(list.stream().min(String::compareTo).get());
    }
    
    @Test
    public void reduceTest() {
        list.add("aa");
        list.add("bb");
        list.add("cc");
        
        System.out.println(list.stream().reduce("00", (str1, str2) -> str1.concat(str2)));// 00aabbcc
        System.out.println(list.stream().reduce("00", String::concat));// 00aabbcc
        
        BinaryOperator<Integer> operator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return Integer.sum(integer, integer2);
            }
        };
        System.out.println(operator.apply(1, 2));// 3
    }
    
    @Test
    public void collectTest() {
        list.add("张三");
        list.add("李四");
        list.add("王五");
        
        list.stream().collect(Collectors.toCollection(() -> new ArrayList<>())).forEach(System.out::println);
        list.stream().collect(Collectors.toCollection(ArrayList::new)).forEach(System.out::println);
        
        List<String> stringList = list.stream().collect(Collectors.toList());
        
        Set<String> stringSet = list.stream().collect(Collectors.toSet());
    }
}
