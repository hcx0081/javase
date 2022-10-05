package com.javase.sale;

/**
 * @description:
 */
class WindowByRunnableSecurity implements Runnable {
    private int ticket = 100;
    private boolean loop = true;
    
    @Override
    public void run() {
        // 同步代码块方式一
        while (true) {
            synchronized (this) {// synchronized (WindowByRunnableSecurity.class) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket <= 0) {
                    System.out.println("售罄");
                    loop = false;
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "窗口卖了一张票，剩余：" + (--ticket) + "票");
            }
        }
        
        
        // 同步代码块方式二
        /* while (loop) {
            try {
                sendTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } */
    }
    
    public /* synchronized */ void sendTicket() throws InterruptedException {
        synchronized (this) {// synchronized (WindowByRunnableSecurity.class) {
            Thread.sleep(10);
            if (ticket <= 0) {
                System.out.println("售罄");
                loop = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + "窗口卖了一张票，剩余：" + (--ticket) + "票");
        }
    }
}

public class TicketWindowByRunnableSecurity {
    public static void main(String[] args) {
        WindowByRunnableSecurity window = new WindowByRunnableSecurity();
        new Thread(window).start();
        new Thread(window).start();
        new Thread(window).start();
    }
}