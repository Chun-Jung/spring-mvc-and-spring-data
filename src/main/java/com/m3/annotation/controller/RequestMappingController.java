package com.m3.annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("requestmapping")
public class RequestMappingController {
	
	/** URL restrictions */

	@RequestMapping("view/*")
	@ResponseBody
	public String viewAll(){
		return "<h1>viewAll</h1>";
	}

	@RequestMapping("view/*.json")
	@ResponseBody
	public String viewJson(){
		return "<h1>viewJson</h1>";
	}
	
	@RequestMapping("view/id/*")
	@ResponseBody
	public String view(){
		return "<h1>view</h1>";
	}
	
	@RequestMapping("view/other*")
	@ResponseBody
	public String viewOther(){
		return "<h1>viewOther</h1>";
	}
	
	/** HTTP request method restrictions */
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public String verifyLogin(){
		return "<h1>RequestMethod.POST</h1>";
	}
	
	/** request parameter restrictions */
	
	@RequestMapping(value = "parameters", method = RequestMethod.GET)
	public String parametersPage(){
		return "parameters";
	}
	
	@RequestMapping(value = "parameters", method = RequestMethod.POST, params = {"username!=", "password=abc123", "!root"})
	@ResponseBody
	public String verifyParameters(){
		return "<h1>Verify Success</h1>";
	}
	
	@RequestMapping(value = "parameters", method = RequestMethod.POST)
	@ResponseBody
	public String catchVerifyParametersFail(){
		return "404";
	}
	
	/** request header restrictions */
	
	@RequestMapping(value = "headers", method = RequestMethod.GET)
	public String headerPage(){
		return "headers";
	}
	
	@RequestMapping(value = "headers", method = RequestMethod.POST, headers = {"test-header", "customer-header=spring-mvc"})
	@ResponseBody
	public String verifyHeaders(){
		return "OK";
	}
	
	/** content type restrictions */
	
	@RequestMapping(value = "contentType", method = RequestMethod.GET)
	public String contentTypePage(){
		return "content_type";
	}
	
	@RequestMapping(value = "contentType", method = RequestMethod.POST)
	@ResponseBody
	public String verifyContentType(){
		return "OK";
	}
}
