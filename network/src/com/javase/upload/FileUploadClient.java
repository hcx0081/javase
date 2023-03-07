package com.javase.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * {@code @Description:}
 */
public class FileUploadClient {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8888);
            // 从磁盘中读取文件
            bufferedInputStream = new BufferedInputStream(new FileInputStream("E:\\file.txt"));
            // 向服务端上传文件
            bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            
            byte[] buffer = new byte[5];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}