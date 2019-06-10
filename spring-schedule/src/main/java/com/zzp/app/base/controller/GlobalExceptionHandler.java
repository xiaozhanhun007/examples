package com.zzp.app.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 全局异常处理handler
 * @Author karyzeng
 * @since 2019.06.10
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Object handleBadRequest(HttpServletRequest request, HttpServletResponse response, RuntimeException e) {
        return "运行时异常";
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handleBadRequest(HttpServletRequest request, HttpServletResponse response, Exception e) {

		/*
		 * 业务逻辑异常
		 */
        if (e instanceof NullPointerException) {
            return "空指针异常";
        }

        /**
         * 系统内部异常，打印异常栈
         */
        logger.error("Error: handle System Exception StackTrace : ", e);

        return "系统异常";
    }
}
