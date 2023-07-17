package com.javase.enumeration;

/**
 * {@code @Description:} 使用enum关键字定义枚举类
 */
public enum SeasonEnum {
    // 枚举成员默认使用public static final修饰
    SPRING("春天", "温暖"),// public static final SeasonEnum SPRING = new SeasonEnum("春天", "温暖");
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷");
    /*
     * 如果是无参构造器，则是：
     * SPRING,SUMMER,AUTUMN,WINTER;
     * */
    
    private String name;
    private String desc;
    
    // 默认是私有化的
    SeasonEnum(String name, String desc) {
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
    //    return "SeasonEnum{" +
    //            "name='" + name + '\'' +
    //            ", desc='" + desc + '\'' +
    //            '}';
    // }
}
