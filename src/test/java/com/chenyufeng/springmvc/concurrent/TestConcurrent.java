package com.chenyufeng.springmvc.concurrent;

import junit.framework.Test;

/**
 * by chenyufeng on 2017/5/18 .
 */
public class TestConcurrent {

    /**
     * 某线程执行print()方法，则该对象加锁，其他线程将无法执行该对象的所有synchronized块；
     */
    public synchronized void print() {

    }

    /**
     * 同上，更能体现synchronized的本质
     */
    public void print01() {
        //锁住本对象
        synchronized (this) {

        }
    }

    /**
     * 执行print02()，会给对象a加锁，注意不是给TestConcurrent的对象加锁，
     * 也就是说TestConcurrent对象的其他synchronized方法不会因为print02()而被锁。同步代码块执行完，则释放对a的锁。
     */
    private String a = "test";
    public void print02() {
        //锁住a对象
        synchronized (a) {

        }
    }
    public synchronized void t() {
        //这个同步代码块不会因为print02()而锁定
    }

    /**
     * 为了锁住一个对象的代码块而不影响该对象其他synchronized块的高性能写法
     */
    private byte[] lock = new byte[0];
    public void print03() {
        synchronized (lock) {

        }
    }
    public synchronized void t02() {

    }

    /**
     * 静态方法的锁，以下两者效果相同
     * 静态方法的同步是指同步在该方法所在的类对象上，因为Java虚拟机中一个类只能对应一个类对象，所以同时只允许一个线程执行同一个类中的静态同步方法。
     */
    public synchronized static void print04() {

    }

    public static void print05() {
        synchronized (Test.class) {

        }
    }


}
