package com.javase.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @Description:
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("e:\\fileByObject.txt"));
    
        //读取的顺序需要和保存的顺序一致，否则会出现异常
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readUTF());
        
        objectInputStream.close();
    }
    
}
