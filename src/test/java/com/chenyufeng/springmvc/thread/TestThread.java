package com.chenyufeng.springmvc.thread;

/**
 * by chenyufeng on 2017/5/18 .
 */

import org.junit.Test;

/**
 * Java多线程，继承Thread类，重写该类的run方法
 */
public class TestThread {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 3) {
                Thread myThread1 = new MyThread(); // 创建一个新的线程 myThread1 此线程进入新建状态
                Thread myThread2 = new MyThread(); // 创建一个新的线程 myThread2 此线程进入新建状态
                myThread1.start();   // 调用start()方法使得线程进入就绪状态
                myThread2.start();   // 调用start()方法使得线程进入就绪状态
            }
        }
    }

    /**
     * Thread匿名子类
     */
    @Test
    public void testAnonymousThread() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("running");
            }
        };
        thread.start();
    }
}

class MyThread extends Thread {

    private int i = 0;

    @Override
    public void run() {
        for (i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}



