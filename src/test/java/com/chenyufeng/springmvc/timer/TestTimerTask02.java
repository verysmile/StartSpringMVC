package com.chenyufeng.springmvc.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * by chenyufeng on 2017/5/18 .
 */
public class TestTimerTask02 {

    /**
     * 优势：
     * （1）启动或者取消任务是可以控制；
     * （2）第一次执行任务时可以指定想要的delay时间；
     *
     * 在实现时，Timer类可以调度任务，Timertask则是通过在run()方法里实现具体任务。Timer实例可以调度多任务，它是线程安全的。
     * @param args
     */
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // task to run goes here
                System.out.println("Hello !!!");
            }
        };
        Timer timer = new Timer();
        long delay = 0;
        long intevalPeriod = 1 * 1000;
        // schedules the task to be run in an interval
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);
    }
}
