package com.etoak.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
public class HelloController {

	
		// TODO Auto-generated method stub
		/*//����ǰ�˲���
		String name = request.getParameter("name");
		//����ModelAndView����ҳ��
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("hello");
		
		//��request���д�ֵ
		mv.addObject("result",name);
		
		return mv;*/
	
	public String bean(String name,Model model){
		System.out.println(name);
		model.addAttribute("result",name);
		
		return "hello";
	}


}
