package com.javase.method;


/**
 * @Description:
 */
public class EmergencyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
    }
}
