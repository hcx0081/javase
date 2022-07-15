package com.javase.map;

import java.util.*;

/**
 * @description:
 */
public class HashMapFor {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap<>();
        hashMap.put(11, "欧文");
        hashMap.put(24, "科比");
        hashMap.put(null, "张三");
        hashMap.put(55, null);
        hashMap.put(100, null);
        
        System.out.println(hashMap);//{null=张三, 100=null, 55=null, 24=科比, 11=欧文}
        
        /*一、通过keySet()取出key访问value*/
        Set keySet = hashMap.keySet();
        
        //1.取出所有的key值，通过增强for循环遍历key获取对应的value
        for (Object key : keySet) {
            System.out.println(key + "=" + hashMap.get(key));
            //null=张三
            //100=null
            //55=null
            //24=科比
            //11=欧文
        }
        //2.取出所有的key值，通过迭代器遍历key获取对应的value
        Iterator iterator1 = keySet.iterator();
        while (iterator1.hasNext()) {
            Object key = iterator1.next();
            System.out.println(key + "=" + hashMap.get(key));
            //null=张三
            //100=null
            //55=null
            //24=科比
            //11=欧文
        }
        
        /*二、通过values()取出所有的value，不包含key*/
        Collection values = hashMap.values();
        
        //1.通过增强for循环遍历取出value，不包含key
        for (Object value : values) {
            System.out.println(value);
            //张三
            //null
            //null
            //科比
            //欧文
        }
        //2.通过迭代器遍历取出value，不包含key
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value = iterator2.next();
            System.out.println(value);
            //张三
            //null
            //null
            //科比
            //欧文
        }
        
        /*三、通过entrySet()取出Map.Entry一次性访问key和value这两个值*/
        Set entrySet = hashMap.entrySet();//返回Set<Map.Entry<K,V>>
        
        //1.取出所有的Map.Entry，通过增强for循环遍历Map.Entry取出所有的key和value
        for (Object entryO : entrySet) {
            Map.Entry entry = (Map.Entry) entryO;
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        //2.取出所有的Map.Entry，通过迭代器遍历Map.Entry取出所有的key和value
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator3.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
