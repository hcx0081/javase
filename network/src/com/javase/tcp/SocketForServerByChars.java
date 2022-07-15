package com.javase.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 */
public class SocketForServerByChars {
    public static void main(String[] args) throws IOException {
        //1.绑定一个端口号进行监听，等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.接收客户端的请求
        //接收到请求前，等待客户端的连接，会发生阻塞
        //接收到请求后，与客户端进行连接，程序继续
        Socket socket = serverSocket.accept();
        
        System.out.println("服务器端连接了客户端的 socket：" + socket.getClass());
        
        //3.创建一个转换流包装字节输入流读取数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        
        //4.创建一个转换流包装字节输出流写入数据
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,client");
        
        //需要手动刷新数据，否则写入不了数据
        bufferedWriter.flush();
        //设置写入结束标记
        socket.shutdownOutput();
        
        //5.关闭
        outputStream.close();
        bufferedReader.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器端退出");
    }
}
