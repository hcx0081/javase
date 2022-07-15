package com.javase.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Description:
 */
public class FileUploadClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //从磁盘中读取文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("e:\\电次.png"));
        //向服务器端上传文件
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        int len;
        while ((len=bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(len);
        }
        bufferedOutputStream.flush();
        socket.shutdownOutput();
    
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
    }
}
