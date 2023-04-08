package com.javase.dynamicbinding;

/**
 * {@code @Description:}
 */
public class Base {
    public void methodOne() {
        System.out.print("A");
        methodTwo();
    }
    
    public void methodTwo() {
        System.out.print("B");
    }
}

class Derived extends Base {
    public static void main(String[] args) {
        Base b = new Derived();
        b.methodOne();// ABCD
    }
    
    public void methodOne() {
        super.methodOne();
        System.out.print("D");
    }
    
    public void methodTwo() {
        super.methodTwo();
        System.out.print("C");
    }
}