package com.example.restaurant.controller;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;



public class BaseController {
    protected static final Logger logger= LoggerFactory.getLogger(BaseController.class);

    protected static final  String principalValue="用户";


    /*@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    protected final ErrorInfo baseExceptionHander(HttpServletRequest req, Throwable throwable){
        throwable.printStackTrace();
        logger.error("Controller error!",throwable);
        throwable= ExceptionUtils.getRootCause(throwable);
        return new ErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(),throwable.getClass().getName(), MyExceptionUtils.formatMessage(throwable),new Date());
    }*/
    protected <T> ResponseEntity<T> ok(T object){
        return new ResponseEntity<>(object, HttpStatus.MULTI_STATUS.OK);
    }
    protected <T> ResponseEntity<T> ok(T object, HttpHeaders httpHeaders){
        return new ResponseEntity<>(object,httpHeaders, HttpStatus.MULTI_STATUS.OK);
    }
    protected ResponseEntity<Void> v(){
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.MULTI_STATUS.OK);
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
