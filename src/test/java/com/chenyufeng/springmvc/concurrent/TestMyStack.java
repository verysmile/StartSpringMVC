package com.chenyufeng.springmvc.concurrent;

import org.junit.Test;

/**
 * by chenyufeng on 2017/5/18 .
 */
public class TestMyStack {
     int idx = 0;
     char[] data = new char[6];

     public synchronized void push(char c) {
         data[idx] = c;
         idx++;
     }

     public synchronized char pop() {
         idx--;
         return data[idx];
     }

     public static void main(String args[]) {
         TestMyStack testMyStack = new TestMyStack();
         //下面对象testMyStack被加锁，严格的说是对象testMyStack的所有synchronized块被加锁，
         //如果存在另一个试图访问testMyStack的线程T，那么T无法执行testMyStack对象的push和pop方法。

         //对象testMyStack被加锁
         testMyStack.pop();
     }

    /**
     * Java中的锁是针对同一个对象的，不是针对class的。
     * 但是Java不能同时对一个代码块加两个锁。
     */
    TestMyStack testMyStack = new TestMyStack();
     TestMyStack testMyStack2 = new TestMyStack();
//     testMyStack.pop();
//     testMyStack2.pop();
}
