package com.javase;

/**
 * @description: 自定义异常
 */
class DivideByZeroException extends RuntimeException {
    public DivideByZeroException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        if (b == 0) {
            throw new DivideByZeroException("除数不能是0");// 抛出异常的实例对象
        }
        int result = a / b;
        System.out.println(result);
        /*
        * Exception in thread "main" com.javase.DivideByZeroException: 除数不能是0
        *   at com.javase.CustomException.main(CustomException.java:17)
        *  */
    }
}