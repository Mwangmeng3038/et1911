package com.etoak.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.etoak.commons.VerifyCode;

@Controller
public class CodeController {
	
	@GetMapping("/code")
	public void code(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//创建一个VerifyCode,获得他的表达式结果
		VerifyCode code = new VerifyCode();
		BufferedImage image = code.createImage();
		request.getSession().setAttribute("code",code.getResult()+"");

		//向前端写图片
		
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		ImageIO.write(image,"JPEG",response.getOutputStream());
	}
	
}