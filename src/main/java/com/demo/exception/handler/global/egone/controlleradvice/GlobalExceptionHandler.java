package com.demo.exception.handler.global.egone.controlleradvice;

import com.demo.exception.handler.global.EgoneAndEgtwoException;
import com.demo.exception.handler.global.egone.myexception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * 捕获异常统一处理egone:2/3
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public void handleBizExp(HttpServletRequest request, Exception ex){
        request.getSession(true).setAttribute("message", ex.getMessage());
        System.out.println("异常处理1 ："+ex.getMessage());
    }

    @ExceptionHandler(EgoneAndEgtwoException.class)
    @ResponseBody
    public void handleOneAndTwo(HttpServletRequest request, Exception ex){
        request.getSession(true).setAttribute("message", ex.getMessage());
        System.out.println("异常处理1 ："+ex.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    public ModelAndView handSql(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", ex.getMessage());
        mv.setViewName("sql_error");
        return mv;
    }



}
