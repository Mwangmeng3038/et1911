 package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
 * 用于测试参数传递
 * 使用HttpServletRequest接受参数
 * 使用基本数据类型 和 String接收参数*
 * */
 @Controller
 @RequestMapping("/simple")
public class SimpleController {
	 
	 
	 @RequestMapping("/servlet")
	 public String servlet(HttpServletRequest request){
		 //接收前端传入的参数name
		 String name = request.getParameter("name");
		 //name == null || "".equals(name)
		 System.out.println(name);
		 if(StringUtils.isEmpty(name)){
			 name = "World!";
		 }
		 //
		 request.setAttribute("result", "Hello:" + name );
		 //
		 return "param";
	 }
	 
	 @RequestMapping(value="/simple",method = {RequestMethod.GET})
	 public ModelAndView simple(@RequestParam(required = false,defaultValue = "1")int id,String name){
		 System.out.println("id param - " + id);
		 System.out.println("name param - " + name);
		 
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("result","ModelAndView传值");
		 mv.setViewName("param");
		 return mv;
	 }
}
