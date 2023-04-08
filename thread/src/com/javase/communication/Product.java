package com.javase.communication;

/**
 * {@code @Description:}
 */

/**
 * 店员
 */
class Clerk {
    private int productCount = 0;
    
    // 店员添加商品，该同步方法的锁为clerk对象
    public synchronized void addProduct() {
        if (productCount < 20) {
            System.out.println("店员开始添加第" + (++productCount) + "个商品");
            // 唤醒一个线程
            notify();
        } else {
            try {
                // 阻塞当前线程
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    /* 上下两个方法共用一个锁，即clerk对象 */
    // 店员减少商品，该同步方法的锁为clerk对象
    public synchronized void subProduct() {
        if (productCount > 0) {
            System.out.println("店员开始减少第" + (productCount--) + "个商品");
            // 唤醒一个线程
            notify();
        } else {
            try {
                // 阻塞当前线程
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 生产者
 */
class Producer extends Thread {
    private Clerk clerk;
    
    public Producer(String name, Clerk clerk) {
        super(name);
        this.clerk = clerk;
    }
    
    @Override
    public void run() {
        System.out.println(getName() + "：开始生产产品");
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}

/**
 * 消费者
 */
class Consumer extends Thread {
    private Clerk clerk;
    
    public Consumer(String name, Clerk clerk) {
        super(name);
        this.clerk = clerk;
    }
    
    @Override
    public void run() {
        System.out.println(getName() + "：开始消费产品");
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.subProduct();
        }
    }
}

public class Product {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        new Producer("生产者", clerk).start();
        new Consumer("消费者", clerk).start();
    }
}