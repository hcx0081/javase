package com.javase.sale;

/**
 * @description:
 */
class WindowByRunnable implements Runnable {
    private int ticket = 5;
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticket <= 0) {
                System.out.println("售罄");
                break;
            }
            System.out.println(Thread.currentThread().getName() + "窗口卖了一张票，剩余：" + (--ticket) + "票");
        }
    }
}

public class TicketWindowByRunnable {
    public static void main(String[] args) {
        WindowByRunnable window = new WindowByRunnable();
        new Thread(window).start();
        new Thread(window).start();
        new Thread(window).start();
    }
}