package com.javase.num;

/**
 * @Description:
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);// false
        
        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4);// false
        
        Integer i5 = 127;
        Integer i6 = 127;
        System.out.println(i5 == i6);// true
        
        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);// false
        
        Integer i9 = Integer.valueOf(127);
        Integer i10 = Integer.valueOf(127);
        System.out.println(i9 == i10);// true
    
        Integer i11 = Integer.valueOf(128);
        Integer i12 = Integer.valueOf(128);
        System.out.println(i11 == i12);// false
        
        Integer i13 = 127;
        int i14 = 127;
        System.out.println(i13 == i14);// true，会先将包装类型转换为基本类型再进行比较
        
        Integer i15 = 128;
        int i16 = 128;
        System.out.println(i15 == i16);// true，会先将包装类型转换为基本类型再进行比较
    }
}
