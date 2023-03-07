package com.javase.thread;

import com.javase.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * {@code @Description:}
 */
public class ClientConnectServerThread extends Thread {
    private Socket socket;
    
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message Message = (Message) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    
    public Socket getSocket() {
        return socket;
    }
    
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}