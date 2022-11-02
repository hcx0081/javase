package com.javase.map;

import java.util.*;

/**
 * @description:
 */
public class HashMapFor {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap<>();
        hashMap.put(11, "zs");
        hashMap.put(22, "ls");
        hashMap.put(null, "ww");
        hashMap.put(24, null);
        
        System.out.println(hashMap);// {null=ww, 22=ls, 24=null, 11=zs}
        
        /* 一、通过keySet()获取所有的key访问value */
        Set keySet = hashMap.keySet();
        
        // 1.获取所有的key，通过增强for循环遍历key获取对应的value
        for (Object key : keySet) {
            System.out.println(key + "=" + hashMap.get(key));
            // null=ww
            // 22=ls
            // 24=null
            // 11=zs
        }
        // 2.获取所有的key，通过迭代器遍历key获取对应的value
        Iterator iterator1 = keySet.iterator();
        while (iterator1.hasNext()) {
            Object key = iterator1.next();
            System.out.println(key + "=" + hashMap.get(key));
            // null=ww
            // 22=ls
            // 24=null
            // 11=zs
        }
        
        /* 二、通过values()直接访问所有的value，不包含key */
        Collection values = hashMap.values();
        
        // 1.通过增强for循环遍历直接访问所有的value，不包含key
        for (Object value : values) {
            System.out.println(value);
            // ww
            // ls
            // null
            // zs
        }
        // 2.通过迭代器遍历直接访问所有的value，不包含key
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value = iterator2.next();
            System.out.println(value);
            // ww
            // ls
            // null
            // zs
        }
        
        /* 三、通过entrySet()获取Map.Entry一次性访问key和value */
        Set entrySet = hashMap.entrySet();// 返回Set<Map.Entry<K,V>>
        
        // 1.获取Map.Entry，通过增强for循环遍历Map.Entry获取所有的key和value
        for (Object entry : entrySet) {
            Map.Entry mapEntry = (Map.Entry) entry;
            System.out.println(mapEntry.getKey() + "=" + mapEntry.getValue());
        }
        // 2.获取Map.Entry，通过迭代器遍历Map.Entry获取所有的key和value
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) iterator3.next();
            System.out.println(mapEntry.getKey() + "=" + mapEntry.getValue());
        }
    }
}
