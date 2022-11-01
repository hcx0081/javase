package com.javase.compare;

/**
 * @Description:
 */
public class Person implements Comparable<Person> {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
    // 指定Person的排序方式：按照年龄从低到高进行排序，再按照姓名从低到高进行排序
    @Override
    public int compareTo(Person o) {
        if (this.age > o.age) {
            return 1;
        }
        if (this.age < o.age) {
            return -1;
        }
        // return 0// 不排序姓名
        return this.name.compareTo(o.name);// 排序姓名
    }
}
