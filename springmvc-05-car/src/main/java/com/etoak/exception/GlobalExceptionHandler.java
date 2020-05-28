package com.etoak.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Et1911LoginException.class)
	public ModelAndView handlLoginException(Et1911LoginException e){
		String msg = e.getMessage();
		log.error(msg,e);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("error",msg);
		mv.setViewName("login");
		return mv;
	}
	
	
	/*
	 * 表示这个方法只拦截ParamExceptiono异常
	 * */
	@ExceptionHandler(ParamException.class)
	public ModelAndView handleParamException(ParamException e){
		
		//异常信息
		String message = e.getMessage();
		
		log.error(message,e);
		ModelAndView mv = new ModelAndView();
		mv.addObject("paramError",message);
		// /templates/car/add.html 
		mv.setViewName("car/add");
		return mv;
	}
}
