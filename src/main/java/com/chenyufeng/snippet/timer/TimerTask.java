package com.chenyufeng.snippet.timer;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * by chenyufeng on 2017/5/24 .
 */

/**
 * 在SpringMVC中比较推荐的定时任务，使用@Component、@Scheduled的方式实现；
 * 其他三种定时任务参考测试类中的timer;
 */
@Component
public class TimerTask {

    private static Logger logger = Logger.getLogger(TimerTask.class);

    //可以可以详见cron表达式
    @Scheduled(cron="0/500 * *  * * ? ")
    public void taskCycle() {
        logger.debug("This is debug message");
    }

    @Scheduled(fixedRate = 500000, initialDelay = 600000)
    public void taskCycle2() {
        logger.debug("===============");
    }
}
