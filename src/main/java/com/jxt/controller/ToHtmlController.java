package com.jxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/12/15 0015.
 */
@Controller
@RequestMapping("/toHtml")
public class ToHtmlController {

    @RequestMapping("/test")
    public String toTestHtml(){
        return "test";
    }

    @RequestMapping("index")
    public String toIndxe(){
        return "index";
    }

    @RequestMapping(value = "writeBlog")
    public String writeBlog(){
        return "writeBlog";
    }
}
