package com.javase;


/**
 * @description:
 */
interface Usb<T> {
    T con(T t);
}

class Computer implements Usb<String> {// 具体类型String替换泛型T
    
    @Override
    public String con(String s) {
        return null;
    }
}

public class GenericInterface {
    public static void main(String[] args) {
        Computer computer = new Computer();
    }
}