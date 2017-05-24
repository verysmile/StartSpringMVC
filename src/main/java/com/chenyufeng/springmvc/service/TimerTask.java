package com.chenyufeng.springmvc.service;

import com.chenyufeng.springmvc.controller.BasketballController;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * by chenyufeng on 2017/5/24 .
 */
@Component
public class TimerTask {

    private static Logger logger = Logger.getLogger(TimerTask.class);

    @Scheduled(cron="0/5 * *  * * ? ")
    public void taskCycle() {
        logger.debug("This is debug message");
    }
}
