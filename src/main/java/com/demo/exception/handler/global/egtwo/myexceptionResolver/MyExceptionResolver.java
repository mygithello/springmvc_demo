package com.demo.exception.handler.global.egtwo.myexceptionResolver;

import com.demo.exception.handler.global.EgoneAndEgtwoException;
import com.demo.exception.handler.global.egtwo.myexception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
/**
 * 捕获异常统一处理egtwo:2/3
 */
public class MyExceptionResolver implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        if(e instanceof MyException){
            System.out.println("异常处理2 ："+e.getMessage());
        }
        else if(e instanceof SQLException){

        }
        else if(e instanceof EgoneAndEgtwoException){
            System.out.println("异常处理2 ："+e.getMessage());
        }
        return new ModelAndView("index");
    }
}
