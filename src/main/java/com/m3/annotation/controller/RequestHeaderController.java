package com.m3.annotation.controller;

import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("requestheader")
public class RequestHeaderController {

	@RequestMapping("foo")
	@ResponseBody
	public String foo(@RequestHeader(value = "User-Agent") String userAgent,
						@RequestHeader(value = "Content-Type", required = false) String contentType){
		return String.format("User-Agent: %s, Content-Type: %s", userAgent, contentType);
	}
	
	@RequestMapping("bar")
	@ResponseBody
	public String bar(@RequestHeader MultiValueMap<String, String> multiValueMap){
		Set<String> keys = multiValueMap.keySet();
		StringBuilder sb = new StringBuilder();
		sb.append("<h1>MultiValueMap</h1>");
		keys.forEach(key -> sb.append(key + ": " + multiValueMap.get(key) + "<br />"));
		return sb.toString();
	}
	
	@RequestMapping("foobar")
	@ResponseBody
	public String foobar(@RequestHeader HttpHeaders httpHeaders){
		Set<String> keys = httpHeaders.keySet();
		StringBuilder sb = new StringBuilder();
		sb.append("<h1>HttpHeaders</h1>");
		keys.forEach(key -> sb.append(key + ": " + httpHeaders.get(key) + "<br />"));
		return sb.toString();
	}
}
