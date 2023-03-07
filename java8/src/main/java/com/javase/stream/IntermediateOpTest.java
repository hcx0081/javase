package com.javase.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * {@code @Description:}
 */
public class IntermediateOpTest {
    List<String> list = new ArrayList<>();
    
    @Test
    public void testCreate() {
        list.add("张三");
        list.add("张三");
        list.add("李四");
        list.add("王五");
        
        // 查询集合中的张三
        list.stream().filter("张三"::equals).forEach(System.out::println);
        
        // 限制元素个数
        list.stream().filter("张三"::equals).limit(1).forEach(System.out::println);
        
        // 查询集合中不重复的张三
        list.stream().filter("张三"::equals).distinct().forEach(System.out::println);
    }
    
    @Test
    public void testMap() {
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        
        // 将集合中所有元素转换为大写
        Stream<String> stream = list.stream().map(String::toUpperCase);
        stream.forEach(System.out::println);
    }
    
    @Test
    public void testFlatMap() {
        ArrayList list1 = new ArrayList();
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");
        
        ArrayList list2 = new ArrayList();
        list2.add("dd");
        list2.add("ee");
        list2.add("ff");
        
        
        // list1.add(list2);// [aa, bb, cc, [dd, ee, ff]]
        System.out.println(list1);
        list1.addAll(list2);// [aa, bb, cc, dd, ee, ff]
        System.out.println(list1);
        
        
        list.add("aa");
        list.add("bb");
        list.add("cc");
        /* 类似于Collection接口中的add()方法，添加一个集合到一个集合中则是嵌套这个集合 */
        Stream<Stream<String>> stream1 = list.stream().map(new Function<String, Stream<String>>() {
            @Override
            public Stream<String> apply(String s) {
                return fromStringToStream(s);
            }
        });
        stream1 = list.stream().map(this::fromStringToStream);
        stream1.forEach(strStream -> strStream.forEach(System.out::println));
        
        /* 类似于Collection接口中的addAll()方法，添加一个集合到一个集合中则是嵌套这个集合中的所有元素 */
        Stream<String> stream2 = list.stream().flatMap(new Function<String, Stream<? extends String>>() {
            @Override
            public Stream<? extends String> apply(String s) {
                return fromStringToStream(s);
            }
        });
        stream2 = list.stream().flatMap(this::fromStringToStream);
        stream2.forEach(System.out::println);
    }
    
    Stream<String> fromStringToStream(String str) {
        ArrayList<String> list = new ArrayList<>();
        list.add(str);
        return list.stream();
    }
    
    @Test
    public void testSort() {
        list.add("cc");
        list.add("bb");
        list.add("aa");
        
        list.stream().sorted().forEach(System.out::print);// aabbcc
        System.out.println();
        list.stream().sorted(String::compareTo).forEach(System.out::print);// aabbcc
    }
}