package com.javase.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @Description:
 */
public class Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        byte[] bytes = "hello,receiver".getBytes(StandardCharsets.UTF_8);
        //DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9999);
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.123.24"), 9999);
        datagramSocket.send(datagramPacket);
        
        /*注意此处需要修改分配空间，因为datagramPacket的大小是上面发送信息时的大小*/
        bytes = new byte[1024];
        datagramPacket = new DatagramPacket(bytes, bytes.length);
        //将接收到的数据存入DatagramPacket对象，如果没有数据则会阻塞等待，直到接收到数据
        datagramSocket.receive(datagramPacket);
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data, 0, length));
        
        datagramSocket.close();
    }
}
