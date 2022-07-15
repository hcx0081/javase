package com.javase.sale;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;

import static java.lang.Thread.sleep;

/**
 * @description:
 */
public class TicketWindowByRunnable {
    public static void main(String[] args) {
        WindowByRunnable window = new WindowByRunnable();
        new Thread(window).start();
        new Thread(window).start();
        new Thread(window).start();
    }
}

class WindowByRunnable implements Runnable {
    private int ticket = 5;
    
    @Override
    public void run() {
        while (true) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticket <= 0) {
                System.out.println("售罄");
                break;
            }
            System.out.println(Thread.currentThread() + "窗口卖了一张票，剩余：" + (--ticket) + "票");
        }
    }
}