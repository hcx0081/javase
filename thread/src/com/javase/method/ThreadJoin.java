package com.javase.method;

import static java.lang.Thread.sleep;

/**
 * @description:
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new EmergencyThread());
        thread.start();
        for (int i = 0; i < 4; i++) {
            if (i == 2) { //当主线程i为2时线程插队，等到插队的线程执行完成后主线程才继续执行
                thread.join();
            }
            sleep(1000);
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
        //Thread-0：0
        //main：0
        //Thread-0：1
        //main：1
        //Thread-0：2
        //Thread-0：3
        //main：2
        //main：3
    }
}

class EmergencyThread implements Runnable {
    
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
    }
}
