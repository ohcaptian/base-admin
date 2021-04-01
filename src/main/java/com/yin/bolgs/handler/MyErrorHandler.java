package com.yin.bolgs.handler;
/**
 * @author 17694
 * @date 2021/04/01
 **/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @des : 异常公共处理
 * @ClassName : MyErrorHandler 
 * @Description :   
 */
@ControllerAdvice
public class MyErrorHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView myException(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", e.getMessage());
        mv.setViewName("common/error/myError");
        return mv;
    }



}
