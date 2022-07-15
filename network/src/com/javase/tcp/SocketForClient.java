package com.javase.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Description:
 */
public class SocketForClient {
    public static void main(String[] args) throws IOException {
        //1.连接服务器
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket：" + socket.getClass());
        
        //2.创建一个字节输出流写入数据
        OutputStream socketOutputStream = socket.getOutputStream();
        socketOutputStream.write("hello,server".getBytes(StandardCharsets.UTF_8));
        //设置写入结束标记
        socket.shutdownOutput();
        
        //3.创建一个字节输入流读取数据
        InputStream socketInputStream = socket.getInputStream();
        int len;
        byte[] bytes = new byte[1024];
        while ((len = socketInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        
        //4.关闭
        socketOutputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
