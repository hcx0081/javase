package com.javase.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * {@code @Description:}
 */
public class StreamTest {
    /**
     * 通过集合创建
     */
    @Test
    public void collectionTest() {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        
        // 顺序流
        Stream<String> stream = list.stream();
        // 并行流
        Stream<String> parallelStream = list.parallelStream();
    }
    
    /**
     * 通过数组创建
     */
    @Test
    public void arrayTest() {
        String[] strings = new String[]{"张三", "李四", "王五"};
        Stream<String> stream = Arrays.stream(strings);
    }
    
    /**
     * 通过Stream创建
     */
    @Test
    public void streamTest() {
        Stream<String> stream = Stream.of("张三", "李四", "王五");
        
        // 迭代流，以0为初始元素，每次增加2
        Stream.iterate(0, t -> t + 2)
                .limit(10)
                .forEach(System.out::println);
        
        
        // 无限流，无限生成[0, 1)的数
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }
}