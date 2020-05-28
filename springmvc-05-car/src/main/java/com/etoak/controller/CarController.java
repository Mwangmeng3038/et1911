package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;
import com.etoak.exception.ParamException;
import com.etoak.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {
	
	@Autowired
	CarService carService;
	
	@RequestMapping("/toAdd")
	public String toiAdd(){
		return "car/add";
	}
	
	/*
	 * 跳转到列表页面
	 * */
	@RequestMapping("/toList")
	public String toList(){
		return "car/list";
	}
	
	@GetMapping("/list")
	@ResponseBody
	public PageVo<CarVo> queryList(
			@RequestParam(required = false,defaultValue = "1") int pageNum,
			@RequestParam(required = false,defaultValue = "8") int pageSize,
			CarVo carVo,String[] priceList){
		return carService.queryList(pageNum, pageSize, carVo,priceList);
	}
	
	/*
	 * 车辆添加
	 * */
	@RequestMapping("/add")
	public String add(MultipartFile file,
			@Valid Car car,BindingResult bindingResult,
			HttpServletRequest request) throws IllegalStateException, IOException{
		String originalFilename = file.getOriginalFilename();
		
		log.info("文件名字 = {}",file.getOriginalFilename());
		log.info("param car - {}",car);
		
		//先校验Car
		List<ObjectError> allErrors = bindingResult.getAllErrors();
		
		//如果校验失败结果集不为空,则取出错误校验信息
		if(!CollectionUtils.isEmpty(allErrors)){
			//具有缓存机制
			StringBuffer errorBuf = new StringBuffer();
			for(ObjectError error: allErrors){
				String errorMsg = error.getDefaultMessage();
				errorBuf.append(errorMsg).append(";");
			}
			
			//将校验错误信息写到request域,使用请求转发跳转到车辆添加页面
			//request.setAttribute("paramError", errorBuf.toString());
			//return "forward:/car/toAdd";
			
			//抛出ParamException异常,让全局异常处理器处理
			throw new ParamException(errorBuf.toString());
			
		}
		
		//新文件名字: uuid_originalFIlename
		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		String newFilename = uuid + "_" + originalFilename;
		
		//把目标文件瞄准指定存放位置
		File destFile = new File("d:/upload",newFilename);
		
		//执行上传
		file.transferTo(destFile);
		
		//上传图片名字
		car.setPic("/pic/"+newFilename);
		
		carService.addCar(car);
		
		//重定向
		return "redirect:/car/toAdd";
	}
	
	@GetMapping("/getBrand")
	@ResponseBody
	public List<String> getBrand(){
		return carService.getAllBrand();
	}
	
	@GetMapping("/getSeries")
	@ResponseBody
	public List<String> getSeriesByBrand(String brand){
		System.out.println(brand);
		return carService.getSeriesByBrand(brand);
	}
	
	
}
