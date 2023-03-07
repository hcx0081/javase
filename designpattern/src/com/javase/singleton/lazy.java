package com.javase.singleton;

/**
 * {@code @Description:} 懒汉式
 */
class Man {
    private static Man man;
    private String name;
    
    private Man(String name) {
        System.out.println("构造器");
        this.name = name;
    }
    
    public static Man getInstance() {
        if (man == null) {// 如果没有man则创建一个对象
            man = new Man("zs");
        }
        return man;
    }
    
    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class lazy {
    public static void main(String[] args) {
        Man man1 = Man.getInstance();
        System.out.println(man1);
        Man man2 = Man.getInstance();
        System.out.println(man2 == man1);
        // 构造器
        // Man{name='zs'}
        // true
    }
}