package com.javase.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * {@code @Description:}
 */
public class SocketServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            // 1.绑定一个端口号进行监听，等待连接
            serverSocket = new ServerSocket(9999);
            // 2.接收客户端的请求
            // 接收到请求前，等待客户端的连接，会发生阻塞
            // 接收到请求后，与客户端进行连接，程序继续
            socket = serverSocket.accept();
            
            System.out.println("服务端连接了客户端的Socket：" + socket.getInetAddress().getHostAddress());
            
            // 3.创建一个字节输入流读取数据
            inputStream = socket.getInputStream();
            byte[] buffer = new byte[1];
            int len;
            byteArrayOutputStream = new ByteArrayOutputStream();
            while ((len = inputStream.read(buffer)) != -1) {
                /* 错误用法 */
                // System.out.println(new String(buffer, 0, len));
                byteArrayOutputStream.write(buffer, 0, len);
            }
            System.out.println(byteArrayOutputStream);
            
            // 4.创建一个字节输出流写入数据
            outputStream = socket.getOutputStream();
            outputStream.write("hello\n客户端你好".getBytes(StandardCharsets.UTF_8));
            // 禁用输出流，表示完成写入
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5.关闭
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
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
            if (inputStream != null) {
                try {
                    inputStream.close();
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
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("服务端退出");
        }
    }
}