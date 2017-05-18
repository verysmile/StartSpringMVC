package com.chenyufeng.springmvc.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * by chenyufeng on 2017/5/18 .
 */
public class TestTimerTask03 {

    /**
     * ScheduledExecutorService是最理想的定时任务实现方式。
     *
     * 优势：
     * （1）相比Timer的单线程，这里是通过线程池的方式来执行任务的；
     * （2）可以灵活设置第一次执行任务的时间间隔；
     *
     * @param args
     */
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                // task to run goes here
                System.out.println("Hello !!");
            }
        };
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 10, 1, TimeUnit.SECONDS);
    }
}
