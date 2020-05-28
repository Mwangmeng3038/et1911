package com.etoak.bean;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarVo extends Car {
	
	//级别名称
	private String levleName;
	
	//变速箱名称
	private String gearboxName;
	
	//排量
	private String outputVolumeName;
	
	//传到sql中的条件
	@JsonIgnore //spring mvc 在返回结果时不封装被@JsonIgnore注解的属性
	private List<Map<String,Integer>> priceMapList;
	
	//接收前端的车龄条件0-1,或1-3
	@JsonIgnore
	public  String vehicleAge;
	
	//
	@JsonIgnore
	private Integer startYear;
	
	//传到sql的条件
	@JsonIgnore
	private Integer endYear;
	
}
