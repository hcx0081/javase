package com.javase.method;

/**
 * @Description:
 */
public class ThreadYield {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new EmergencyThread());
        thread.start();
        
        for (int i = 0; i < 4; i++) {
            if (i == 2) {// 当主线程i为2时线程礼让
                Thread.yield();
            }
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
        // Thread-0：0
        // main：0
        // main：1
        // Thread-0：1
        // main：2
        // Thread-0：2
        // main：3
        // Thread-0：3
        // Thread-0：4
        // Thread-0：5
        // Thread-0：6
        // Thread-0：7
        // Thread-0：8
        // Thread-0：9
        // Thread-0：10
    }
}