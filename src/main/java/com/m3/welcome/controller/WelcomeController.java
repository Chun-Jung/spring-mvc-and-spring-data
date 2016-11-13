package com.m3.welcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@RequestMapping("")
	@ResponseBody
	public String welcome(){
		return "<h1>Hello Spring MVC</h1>";
	}
}
