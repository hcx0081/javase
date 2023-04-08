package com.javase.aid;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * {@code @Description:}
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("所有线程都已到达屏障点");
        });
        
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    // 执行任务
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + " 到达屏障点");
                    
                    // 在屏障点等待其他线程
                    int position = barrier.await();
                    System.out.println(Thread.currentThread().getName() + " 在第 " + position + " 个位置等待");
                } catch (BrokenBarrierException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}