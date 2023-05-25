package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MessageEx {
	
	@RequestMapping("/")
	public String mssg() {
		return "Welcome To mTouchLabs";
	}
}
