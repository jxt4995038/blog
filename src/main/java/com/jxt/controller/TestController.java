package com.jxt.controller;

import com.jxt.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String Test(){
        logger.debug("进入了{}方法");
        String result = testService.test();
        return result;
    }
}
