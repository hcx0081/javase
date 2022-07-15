package com.javase.reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Description:
 */
public class ReflectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        /*传统方法*/
        //Person person = new Person();
        //person.say();
        
        
        /*反射机制*/
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\IDEA\\IntelliJ IDEA 2021.3.3\\Workspace\\javase\\reflect\\src\\com\\javase\\person.properties"));
        String fullclass = properties.get("fullclass").toString();
        String method = properties.get("method").toString();
        
        
        //加载类
        Class<?> cls = Class.forName(fullclass);//Class.forName("com.javase.reflect.Person")
        //通过加载的类调用无参构造器返回类的实例
        Object person = cls.newInstance();
        System.out.println(person.getClass());//class com.javase.reflect.Person
        
        Method clsMethod = cls.getMethod(method);
        //通过方法对象实现调用方法
        //传统机制：对象.方法()
        //反射机制：方法.invoke(对象)
        clsMethod.invoke(person);//hello
        
        //getField()只能得到公有的属性
        Field name = cls.getField("name");
        System.out.println(name.get(person));//zs
        
        Constructor<?> constructor = cls.getConstructor();//无参构造器
        System.out.println(constructor);//public com.javase.reflect.Person()

        Constructor<?> constructorWithParameter = cls.getConstructor(String.class);
        System.out.println(constructorWithParameter);//public com.javase.reflect.Person(java.lang.String)
    }
}
