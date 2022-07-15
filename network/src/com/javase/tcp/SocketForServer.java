package com.javase.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Description:
 */
public class SocketForServer {
    public static void main(String[] args) throws IOException {
        //1.绑定一个端口号进行监听，等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.接收客户端的请求
        //接收到请求前，等待客户端的连接，会发生阻塞
        //接收到请求后，与客户端进行连接，程序继续
        Socket socket = serverSocket.accept();
        
        System.out.println("服务器端连接了客户端的 socket：" + socket.getClass());
        
        //3.创建一个字节输入流读取数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        
        //4.创建一个字节输出流写入数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes(StandardCharsets.UTF_8));
        //设置写入结束标记
        socket.shutdownOutput();
        
        //5.关闭
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器端退出");
    }
}
