package com.javase.wrap;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @Description:
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("E:\\fileObject.txt"));
            
            // 读取顺序需要与写入顺序一致，否则会抛出异常
            System.out.println(objectInputStream.readInt());
            System.out.println(objectInputStream.readDouble());
            System.out.println(objectInputStream.readBoolean());
            System.out.println(objectInputStream.readUTF());
            System.out.println(objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
