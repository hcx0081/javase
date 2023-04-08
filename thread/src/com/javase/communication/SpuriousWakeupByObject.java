package com.javase.communication;

/**
 * {@code @Description:}
 */
class CountByObject {
    int count = 0;
    
    public synchronized void add() throws InterruptedException {
        while (count != 0) {
            wait();
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "：" + count);
        notify();
    }
    
    public synchronized void sub() throws InterruptedException {
        while (count != 1) {
            wait();
        }
        count--;
        System.out.println(Thread.currentThread().getName() + "：" + count);
        notify();
    }
}


public class SpuriousWakeupByObject {
    public static void main(String[] args) {
        CountByObject countByObject = new CountByObject();
        new Thread(() -> {
            try {
                while (true) {
                    countByObject.add();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "A").start();
        new Thread(() -> {
            try {
                while (true) {
                    countByObject.sub();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "B").start();
        new Thread(() -> {
            try {
                while (true) {
                    countByObject.add();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "C").start();
        new Thread(() -> {
            try {
                while (true) {
                    countByObject.sub();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "D").start();
    }
}