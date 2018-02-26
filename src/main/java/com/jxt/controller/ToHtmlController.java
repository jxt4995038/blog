package com.jxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/12/15 0015.
 */
@Controller
@RequestMapping("/toHtml")
public class ToHtmlController {

    @RequestMapping("/test")
    public String toTestHtml(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "test";
    }

    @RequestMapping("index")
    public String toIndxe(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "index";
    }

    @RequestMapping(value = "writeBlog")
    public String writeBlog(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "writeBlog";
    }

    @RequestMapping(value = "navigation")
    public String navigation(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "navigation";
    }

    @RequestMapping(value = "content")
    public String content(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "content";}

    @RequestMapping(value = "content_left")
    public String contentLeft(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "content_left";}

    @RequestMapping(value = "content_right")
    public String contentRight(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "content_right";}

    @RequestMapping(value = "replyInfo")
    public String replyInfo(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "replyInfo";}

}
