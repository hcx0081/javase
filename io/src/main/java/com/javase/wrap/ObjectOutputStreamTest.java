package com.javase.wrap;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * {@code @Description:}
 */
public class ObjectOutputStreamTest {
    public static void main(String[] args) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\fileObject.txt"));
            
            objectOutputStream.writeInt(100);
            objectOutputStream.writeDouble(100.0);
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeUTF("你好");
            objectOutputStream.writeObject(new Person("zs", 20));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}