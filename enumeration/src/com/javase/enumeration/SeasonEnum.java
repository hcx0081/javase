package com.javase.enumeration;

/**
 * @description: 使用enum关键字定义枚举类
 */
public enum SeasonEnum {
    //枚举对象默认被public final static修饰
    SPRING("春天", "温暖"),//public final static SeasonEnum SPRING = new SeasonEnum("春天", "温暖");
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷");
    /*
     * 如果是无参构造器，则是
     * SPRING,SUMMER,AUTUMN,WINTER;
     * */
    
    private String name;
    private String desc;
    
    //默认是私有化的
    SeasonEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    
    public static void main(String[] args) {
        System.out.println(SPRING);//默认输出该枚举对象的名字，即SPRING
    }
    
    public String getName() {
        return name;
    }
    
    //@Override
    //public String toString() {
    //    return "SeasonEnum{" +
    //            "name='" + name + '\'' +
    //            ", desc='" + desc + '\'' +
    //            '}';
    //}
    
    public String getDesc() {
        return desc;
    }
}
