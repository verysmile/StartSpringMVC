package com.chenyufeng.springmvc.collection;

import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * by chenyufeng on 2017/5/24 .
 */
public class TestConcurrentLinkedQueue {

    @Test
    public void testConcurrentLinkedQueue() {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>();
        concurrentLinkedQueue.add("aaa");
        concurrentLinkedQueue.add("bbb");

        System.out.println(concurrentLinkedQueue);

        System.out.println("队头元素：" + concurrentLinkedQueue.peek());

        System.out.println("============================");
        concurrentLinkedQueue.poll();
        System.out.println(concurrentLinkedQueue);

    }
}
