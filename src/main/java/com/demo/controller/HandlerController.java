package com.demo.controller;

import com.demo.exception.handler.global.EgoneAndEgtwoException;
import com.demo.exception.handler.global.egone.myexception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HandlerController {

    //egone
    @RequestMapping("/globalExceptionHandlerTest")
    public String globalExceptionHandlerTest() throws MyException {
        if(1==1){
            throw new MyException("自定义异常");
        }
        return "index";
    }
    //egtwo
    @RequestMapping("/globalExceptionHandlerTest2")
    public String globalExceptionHandlerTest2() throws
            com.demo.exception.handler.global.egtwo.myexception.MyException {
        if(1==1){
            throw new com.demo.exception.handler.global.egtwo.myexception.MyException("自定义异常");
        }
        return "index";
    }

    //egtwo  egone  若是相同的异常，不会触发两次异常处理，仅仅egone是有效（仅仅@ControllerAdvice注解方式实现的的异常统一处理有效）
    @RequestMapping("/globalExceptionHandlerTest3")
    public String globalExceptionHandlerTest3() throws EgoneAndEgtwoException {
        if(1==1){
            throw new EgoneAndEgtwoException("两个异常统一处理相同的一个异常");
        }
        return "index";
    }

    //此方法抛出的异常不是由GlobalExceptionHandler处理
    //而是在catch块处理
    @RequestMapping("/globalExceptionHandlerTest4")
    public String globalExceptionHandlerTest4() {
        try {
            throw new MyException("自定义异常");
        } catch (MyException e) {
            e.printStackTrace();
        }
        return "index";
    }
}