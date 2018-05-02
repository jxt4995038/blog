package com.jxt.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class LoggerAop {
    private static final Logger logger = LoggerFactory.getLogger(Logger.class);


    @Pointcut("execution(public * com.jxt.controller.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void before(JoinPoint joinPoint){

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        System.out.println(String.valueOf(request.getAttribute("name")));
    }

//    @After("log()")
    public void after(JoinPoint joinPoint){
        System.out.println("after");
    }
}
