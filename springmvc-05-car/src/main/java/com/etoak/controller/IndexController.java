package com.etoak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class IndexController {
	@RequestMapping("/index")
	public String index(){
		
		//webapp/templates/index.html
		return "index";
	}
}