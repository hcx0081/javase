package com.javase.sale;

/**
 * {@code @Description:}
 */
class WindowByThreadSecurity extends Thread {
    private static int ticket = 100;
    private static boolean loop = true;
    private static Object lock = new Object();
    
    @Override
    public void run() {
        
        // 同步代码块方式一
        /* while (true) {
            // 注意此处不可以使用this
            // synchronized (WindowByThreadSecurity.class) {
            synchronized (lock) {
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
        } */
        
        
        // 同步代码块方式二
        while (loop) {
            try {
                sendTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    // 需要使用static修饰
    public static synchronized void sendTicket() throws InterruptedException {
        // 注意此处不可以使用this
        // synchronized (WindowByThreadSecurity.class) {
        // synchronized (lock) {
        Thread.sleep(10);
        if (ticket <= 0) {
            System.out.println("售罄");
            loop = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "窗口卖了一张票，剩余：" + (--ticket) + "票");
        // }
    }
}

public class TicketWindowByThreadSecurity {
    public static void main(String[] args) {
        new WindowByThreadSecurity().start();
        new WindowByThreadSecurity().start();
        new WindowByThreadSecurity().start();
    }
}