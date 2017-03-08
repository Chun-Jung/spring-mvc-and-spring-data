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

	// 會根據延伸檔名(mime type)而決定回傳的Content-Type
	// 例如:*.json回傳的Content-Type為application/json;charset=UTF-8
	@RequestMapping("view/*.json")
	@ResponseBody
	public String viewJson(){
		return "<h1>viewJson</h1>";
	}
	
	@RequestMapping("view/id/*")
	@ResponseBody
	public String view(){
		return "<h1>viewId</h1>";
	}
	
	@RequestMapping("view/other*")
	@ResponseBody
	public String viewOther(){
		return "<h1>viewOther</h1>";
	}
	
	/** HTTP request method restrictions */
	
	@RequestMapping(value = "httpmethod", method = RequestMethod.GET)
	public String loginPage(){
		return "httpmethod";
	}
	
	@RequestMapping(value = "httpmethod", method = RequestMethod.POST)
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
	
	/** request header restrictions */
	
	@RequestMapping(value = "headers", method = RequestMethod.GET)
	public String headerPage(){
		return "headers";
	}
	
	@RequestMapping(value = "headers", method = RequestMethod.POST, headers = {"test-header", "customer-header=spring-mvc", "content-type=text/*"})
	@ResponseBody
	public String verifyHeaders(){
		return "OK";
	}
	
	/** content type restrictions */
	
	@RequestMapping(value = "contenttype", method = RequestMethod.GET)
	public String contentTypePage(){
		return "content_type";
	}
	
	@RequestMapping(value = "contenttype", method = RequestMethod.POST, consumes = {"text/json", "application/json"}, produces = {"text/json", "application/json"})
	@ResponseBody
	public String verifyContentType(){
		return "OK";
	}
	
}
