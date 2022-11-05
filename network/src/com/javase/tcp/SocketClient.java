package com.javase.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Description:
 */
public class SocketClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            // 1.连接服务器
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            System.out.println("客户端Socket：" + socket.getInetAddress().getHostAddress());
            
            // 2.创建一个字节输出流写入数据
            outputStream = socket.getOutputStream();
            outputStream.write("hello\n服务端你好".getBytes(StandardCharsets.UTF_8));
            // 禁用输出流，表示完成写入
            socket.shutdownOutput();
            
            // 3.创建一个字节输入流读取数据
            inputStream = socket.getInputStream();
            int len;
            byte[] buffer = new byte[1];
            byteArrayOutputStream = new ByteArrayOutputStream();
            while ((len = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            System.out.println(byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
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
            System.out.println("客户端退出");
        }
    }
}
