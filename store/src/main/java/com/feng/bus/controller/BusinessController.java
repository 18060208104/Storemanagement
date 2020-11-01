package com.feng.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//返回跳转页面
@RequestMapping("bus")
public class BusinessController {

	/*
	跳转到客户管理
    */
	@RequestMapping("toCustomerManager")
	public String  toCustomerManager(){
		return "business/customer/customerManager";
	}
}
