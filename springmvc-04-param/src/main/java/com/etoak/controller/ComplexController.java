package com.etoak.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.Student;

@Controller
@RequestMapping("/complex")
public class ComplexController {

	// Get���� :
	@GetMapping("/bean")
	public String bean(Student student,Model model) {
		System.out.println(student);
		model.addAttribute("result2","ʹ��Model��ֵ");		
		
		//����ת��
		return "forward:/simple/simple?id=321";
	}
	
	@PostMapping("/array")
	public String array(String[] hobby,ModelMap modelMap){
		for(String hobbyStr : hobby){
			System.out.println("hobby - " + hobbyStr);
		}
		 modelMap.addAttribute("result","ʹ��Model����");
		 return "param";
	}
	
	@PostMapping("/list")
	public String list(Student student,Map<String,Object> map){
		
		//������Ϊ�յ�ʱ�����
		List<String> hobbyList = student.getHobbyList();
		if(!CollectionUtils.isEmpty(hobbyList)){
			hobbyList.forEach(System.out::println);
		}
		map.put("result","ʹ��list    ����");
		return "param";
	}
	
	@PostMapping(value= "/map" , produces = { "text/plain" })
	@ResponseBody  //���Է���json xml ���ı�
	public String map(Student student){
		System.out.println(student.getStuMap());
		
		return "success";
	}
}
