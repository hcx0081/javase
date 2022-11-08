package com.javase.enumeration;

/**
 * @description: 自定义枚举类
 */
public class SeasonCustom {
    public static final SeasonCustom SPRING = new SeasonCustom("春天", "温暖");
    public static final SeasonCustom SUMMER = new SeasonCustom("夏天", "炎热");
    public static final SeasonCustom AUTUMN = new SeasonCustom("秋天", "凉爽");
    public static final SeasonCustom WINTER = new SeasonCustom("冬天", "寒冷");
    
    private String name;
    private String desc;
    
    // 构造器私有化，在其他类就不可以再new
    private SeasonCustom(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDesc() {
        return desc;
    }
    
    /* 不提供setter方法 */
    
    @Override
    public String toString() {
        return "SeasonCustom{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
