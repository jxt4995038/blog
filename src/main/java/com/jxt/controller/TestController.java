package com.jxt.controller;

import com.jxt.controller.response.FailResponse;
import com.jxt.controller.response.IResponse;
import com.jxt.controller.response.SuccessResponse;
import com.jxt.entity.Test;
import com.jxt.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
@RestController
@RequestMapping(value = "test")
public class TestController {
    @Autowired
    private TestService testService;

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public IResponse Test(Integer id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        logger.debug("进入了{}方法");
        Test test;
        try {
            test = testService.test(id);
        }catch (Exception e){
            return new FailResponse(e.getMessage());
        }
        return new SuccessResponse(test);
    }
}
