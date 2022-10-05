package com.javase.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Description:
 */
public class ObjectOutputStreamTest {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("e:\\fileByObject.txt"));
        objectOutputStream.writeInt(100);
        objectOutputStream.writeDouble(10.0);
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeUTF("你好");
        objectOutputStream.close();
    }
}
