package com.jxt.controller;

import com.jxt.controller.response.FailResponse;
import com.jxt.controller.response.IResponse;
import com.jxt.controller.response.SuccessResponse;
import com.jxt.service.BlogTypeService;
import com.jxt.serviceImpl.BlogTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/blogType")
public class BlogTypeController {


    @Autowired
    private BlogTypeService blogTypeService;

    public static Map<String,Object> stringObjectMap;

    @RequestMapping(value = "/showAllTypes",method = RequestMethod.POST)
    public IResponse showAllTypes(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            Map<String,Object> resultMap = BlogTypeServiceImpl.blogTypeMapWithLevel;
            return new SuccessResponse(resultMap);
        }catch (Exception e){
            return new FailResponse(e.getMessage());
        }
    }



}
