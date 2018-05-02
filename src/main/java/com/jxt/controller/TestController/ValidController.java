package com.jxt.controller.TestController;

import com.jxt.entity.Blog;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ValidController {

    //为姓名加上非空及最小长度校验，
    @RequestMapping(value = "/validTest",method = RequestMethod.GET)
    public void validTest(@Valid Blog blog, BindingResult bindingResult){
        System.out.println("title is"+blog.getTitle());
        if(bindingResult.hasErrors()){
            //不符合的话将会输入提示信息
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            System.out.println(bindingResult.getFieldErrors().get(0).getDefaultMessage());// 为了避免大量的校验在前端堆积,影响用户体验，只返回一个错误提示
        }
    }
}
