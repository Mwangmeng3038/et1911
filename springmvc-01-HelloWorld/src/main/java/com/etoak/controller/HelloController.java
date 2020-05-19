package com.etoak.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class HelloController implements HttpRequestHandler {

	public HelloController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���ܲ���
		String name = request.getParameter("name");
		System.out.println("param name - " + name);
		
		//����service,��request��ֵ
		request.setAttribute("result", "Hello" + name);
		
		//����ҳ��(webapp/hello.jsp)
		request.getRequestDispatcher("/hello.jsp").forward(request, response);;
	}

}
