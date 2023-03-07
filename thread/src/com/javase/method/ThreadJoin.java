package com.javase.method;

/**
 * {@code @Description:}
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new EmergencyThread());
        thread.start();
        
        for (int i = 0; i < 4; i++) {
            if (i == 2) {// 当主线程i为2时让线程插队，等到插队的线程执行完成后主线程才继续执行
                thread.join();
            }
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
        // main：0
        // Thread-0：0
        // Thread-0：1
        // main：1
        // Thread-0：2
        // Thread-0：3
        // Thread-0：4
        // Thread-0：5
        // Thread-0：6
        // Thread-0：7
        // Thread-0：8
        // Thread-0：9
        // Thread-0：10
        // main：2
        // main：3
    }
}