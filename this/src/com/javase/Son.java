package com.javase;

/**
 * {@code @Description:}
 */
public class Son extends Father {
    @Override
    public void say() {
        System.out.println(this);
        System.out.println("---");
        super.say();
    }
}