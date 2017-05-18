package com.chenyufeng.springmvc.timer;

import org.junit.Test;

/**
 * by chenyufeng on 2017/5/18 .
 */
public class TestTimerTask01 {

    /**
     * 创建一个Thread，然后在while里一直运行。通过sleep方法来达到定时任务的效果。
     * @param args
     */
    public static void main(String[] args) {
        final long timeInterval = 1000;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Hello");

                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
