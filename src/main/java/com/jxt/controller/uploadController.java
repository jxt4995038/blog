package com.jxt.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/12/15 0015.
 */
@RestController
@RequestMapping("/upload")
public class uploadController {

    @RequestMapping("/imageUpload")
    public void imageUpload(MultipartFile file, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println("进入了这个方法");

    }
}
