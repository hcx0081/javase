package com.javase.sale;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * @description:
 */
public class TicketWindowSecurity {
    public static void main(String[] args) {
        WindowBySecurity window = new WindowBySecurity();
        new Thread(window).start();
        new Thread(window).start();
        new Thread(window).start();
    }
}

class WindowBySecurity implements Runnable {
    private int ticket = 100;
    private boolean loop = true;
    
    @Override
    public void run() {
        while (loop) {
            try {
                sendTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public /*synchronized*/ void sendTicket() throws InterruptedException {
        synchronized (this) {
            sleep(10);
            if (ticket <= 0) {
                System.out.println("售罄");
                loop = false;
                return;
            }
            System.out.println(Thread.currentThread() + "窗口卖了一张票，剩余：" + (--ticket) + "票");
        }
        
    }
}
