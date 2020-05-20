package com.etoak.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etoak.bean.ResultVo;
import com.etoak.bean.Student;
import com.etoak.bean.User;

@RestController//@Controller + @ResponseBody(��Ӧ�õ����з�����)
@RequestMapping("/json")
public class jsonController {
	@PostMapping(value = "/jsonToMap" , produces = "application/json;charaset=UTF-8")
	public Object mapToJson(@RequestBody Map<String,Object> jsonMap){
		System.out.println(jsonMap);
		
		return "{\"msg\":\"success\"}";
	}
	
	@PostMapping("/jsonToList")
	public Map<String,Object> jsonToList(@RequestBody List<User> userList){//@RequestBodyֱ����String����ǰ�˴�������json����
		userList.forEach(x -> System.out.println(x));
		
		Map<String,Object> resultMap = new HashMap<>();
		
		resultMap.put("code", 200);
		resultMap.put("msg", "SUCCESS");
		return resultMap;
		
	}
	
	@PostMapping("/jsonToBean")
	public ResultVo bean(@RequestBody Student student){
		
		System.out.println(student);
		return new ResultVo(200,"success");
	}
	
}
