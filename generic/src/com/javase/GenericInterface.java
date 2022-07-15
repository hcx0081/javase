package com.javase;

interface Usb<T> {
    T con(T t);
}

/**
 * @description:
 */
public class GenericInterface {
}

class Computer implements Usb<String> {//String类型替换泛型T
    
    @Override
    public String con(String s) {
        return null;
    }
}