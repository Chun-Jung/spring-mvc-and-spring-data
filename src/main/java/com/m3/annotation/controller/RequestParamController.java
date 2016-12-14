package com.m3.annotation.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("requestparam")
public class RequestParamController {

	@RequestMapping("foo")
	@ResponseBody
	public String foo(@RequestParam("id") long userId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "tel", defaultValue = "(02)2700-7686") String tel){
		String responseMsg = String.format("userId: %d, name: %s, tel: %s", userId, name, tel);
		return responseMsg;
	}
	
	
	@RequestMapping("bar")
	@ResponseBody
	public String bar(@RequestParam MultiValueMap<String, String> multiValueMap){ // Map<String, String> map
		Set<String> keys = multiValueMap.keySet();
		StringBuilder sb = new StringBuilder();
		sb.append("<h1>MultiValueMap</h1>");
		keys.forEach(key -> sb.append(key + ": " + multiValueMap.get(key) + "<br />"));
		return sb.toString();
	}
}
