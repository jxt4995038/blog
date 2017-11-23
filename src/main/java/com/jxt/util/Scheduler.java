package com.jxt.util;


import com.jxt.controller.TestController;
import com.jxt.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/11/22 0022.
 */
@Component
public class Scheduler {
    private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);
    @Autowired
    private TestService testService;

    @Scheduled(cron="0 0/1 * * * ?")   //每分钟执行一次，防止mysql断开
    public void checkJDBC(){
        testService.connectMysql();
    }
}
