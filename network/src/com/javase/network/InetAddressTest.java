package com.javase.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description:
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);// DESKTOP-6ORNRGV/192.168.106.1
        System.out.println(InetAddress.getByName("DESKTOP-6ORNRGV"));// DESKTOP-6ORNRGV/192.168.106.1
        System.out.println(localHost.getHostName());// DESKTOP-6ORNRGV
        System.out.println(localHost.getHostAddress());// 192.168.106.1
        
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress);// www.baidu.com/14.215.177.38
        System.out.println(inetAddress.getHostName());// www.baidu.com
        System.out.println(inetAddress.getHostAddress());// 14.215.177.38
    }
}
