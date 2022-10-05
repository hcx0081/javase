package com.javase.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @Description:
 */
public class Receiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        
        //将接收到的数据存入DatagramPacket对象，如果没有数据则会阻塞等待，直到接收到数据
        datagramSocket.receive(datagramPacket);
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data, 0, length));
        
        bytes = "hello,sender".getBytes(StandardCharsets.UTF_8);
        //datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8888);
        datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.123.24"), 8888);
        datagramSocket.send(datagramPacket);
        
        datagramSocket.close();
    }
}
