package com.javase.service;

import com.javase.common.Message;
import com.javase.common.MessageType;
import com.javase.common.User;
import com.javase.thread.ClientConnectServerThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


/**
 * {@code @Description:}
 */
public class QqClientService {
    private User user = new User();
    private Socket socket;
    
    public boolean checkUser(String userId, String password) {
        user.setUserId(userId);
        user.setPassword(password);
        boolean b = false;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            
            // 获取
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(user);
            
            // 发送
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Message Message = (Message) objectInputStream.readObject();
            
            if (Message.getMsgType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                clientConnectServerThread.start();
                b = true;
                
            } else {
                socket.close();
                
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return b;
    }
}