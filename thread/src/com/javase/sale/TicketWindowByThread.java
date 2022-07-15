package com.javase.sale;

/**
 * @description:
 */
public class TicketWindowByThread {
    public static void main(String[] args) {
        new WindowByThread().start();
        new WindowByThread().start();
        new WindowByThread().start();
    }
}

class WindowByThread extends Thread {
    private static int ticket = 5;
    
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