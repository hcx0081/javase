package com.javase.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Description:
 */
public class SocketForClientByChars {
    public static void main(String[] args) throws IOException {
        //1.连接服务器
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket：" + socket.getClass());
        
        //2.创建一个转换流包装字节输出流写入数据
        OutputStream socketOutputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socketOutputStream));
        bufferedWriter.write("hello,server");
        bufferedWriter.newLine();
        bufferedWriter.write("hello,server");
        //hello,server
        //hello,server
        
        //需要手动刷新数据，否则写入不了数据
        bufferedWriter.flush();
        //设置写入结束标记
        socket.shutdownOutput();
        
        //3.创建一个转换流包装字节输入流读取数据
        InputStream socketInputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socketInputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        
        //4.关闭
        bufferedReader.close();
        bufferedWriter.close();
        socketOutputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
