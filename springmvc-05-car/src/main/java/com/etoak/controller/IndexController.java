package com.etoak.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.User;

@Controller
class IndexController {
	
	@RequestMapping("/add")
	public String add(String name){
		System.out.println(name);
		return "forward:/index";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public String json(@RequestBody Map<String,String> map){
		System.out.println(map);
		return "SUCCESS";
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		
		//��request���д�ֵ
		request.setAttribute("user", new User(1,"requestUser","",20));
		
		//��session�д�ֵ
		request.getSession().setAttribute("sessionUser", new User(2,"sessionUser","",21));
		
		//���ڲ���thymeleaf
		List<User> userList = new ArrayList<>();
		request.setAttribute("userList", userList);
		
		userList.add(new User(3,"����","",28));
		userList.add(new User(4,"����","",29));
		
		return "index";
	}
	
	
}
