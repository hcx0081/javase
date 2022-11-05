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
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(9999);
            
            byte[] buffer = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            
            // 将接收到的数据存入DatagramPacket对象，如果没有数据则会阻塞等待，直到接收到数据
            datagramSocket.receive(datagramPacket);
            int length = datagramPacket.getLength();
            byte[] data = datagramPacket.getData();
            System.out.println(new String(data, 0, length));
            
            buffer = "hello\n你好".getBytes(StandardCharsets.UTF_8);
            datagramPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 8888);
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}
