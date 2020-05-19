package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	public HelloController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. ��ȡ����
		String name = request.getParameter("name");
		// 2.����Service�����...�ݲ�����
		
		// 3.����ҳ��
		ModelAndView mv = new ModelAndView();
		
		//webapp/pages/hello.jsp
		mv.setViewName("hello");
		
		//��request��ֵ,�൱��request.setAttribute(k.v)
		mv.addObject("result","Hello" + name);
		
		return mv;
	}

}
