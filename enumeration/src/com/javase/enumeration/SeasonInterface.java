package com.javase.enumeration;

public enum SeasonInterface implements Info {
    // 枚举成员默认使用public static final修饰
    SPRING("春天", "温暖") {// public static final SeasonEnum SPRING = new SeasonInterface("春天", "温暖");
        
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", "炎热") {
        @Override
        public void show() {
            System.out.println("夏天在哪里");
        }
    },
    AUTUMN("秋天", "凉爽") {
        @Override
        public void show() {
            System.out.println("秋天在哪里");
        }
    },
    WINTER("冬天", "寒冷") {
        @Override
        public void show() {
            System.out.println("冬天在哪里");
        }
    };
    /*
     * 如果是无参构造器，则是：
     * SPRING,SUMMER,AUTUMN,WINTER;
     * */
    
    private String name;
    private String desc;
    
    // 默认是私有化的
    SeasonInterface(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDesc() {
        return desc;
    }
    
    // @Override
    // public String toString() {
    //     return "SeasonInterface{" +
    //             "name='" + name + '\'' +
    //             ", desc='" + desc + '\'' +
    //             '}';
    // }
}

/**
 * {@code @Description:}
 */
interface Info {
    void show();
}

class m {
    public static void main(String[] args) {
        SeasonInterface.SPRING.show();// 春天在哪里
    }
}
