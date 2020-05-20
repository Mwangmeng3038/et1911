package com.etoak.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
public class HelloController {

	
		// TODO Auto-generated method stub
		/*//接收前端参数
		String name = request.getParameter("name");
		//创建ModelAndView返回页面
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("hello");
		
		//向request域中传值
		mv.addObject("result",name);
		
		return mv;*/
	
	public String bean(String name,Model model){
		System.out.println(name);
		model.addAttribute("result",name);
		
		return "hello";
	}


}
