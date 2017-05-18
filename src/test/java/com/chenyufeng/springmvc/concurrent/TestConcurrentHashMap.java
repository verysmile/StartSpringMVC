package com.chenyufeng.springmvc.concurrent;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * by chenyufeng on 2017/5/18 .
 */
public class TestConcurrentHashMap {

    ConcurrentHashMap<String, String> concurrentHashMap;

    public void CHMdemo() {
        concurrentHashMap.put("1", "11");
    }

    public static void CHMdemo2() {
        final Map<String, AtomicInteger> countMap = new ConcurrentHashMap<String, AtomicInteger>();
        final CountDownLatch endLatch = new CountDownLatch(2);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                AtomicInteger oldValue;
                for (int i = 0; i < 5; i++) {
                    oldValue = countMap.get("a");
                    if (null == oldValue) {
                        AtomicInteger zeroValue = new AtomicInteger(0);
                        oldValue = countMap.put("a", zeroValue);
                        if (null == oldValue) {
                            oldValue = zeroValue;
                        }
                    }
                    oldValue.incrementAndGet();
                }
                endLatch.countDown();
            }
        };
        new Thread(task).start();
        new Thread(task).start();

        try {
            endLatch.await();
            System.out.println(countMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCHMdemo2() {
        CHMdemo2();
    }
}
