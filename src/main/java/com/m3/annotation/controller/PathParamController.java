package com.m3.annotation.controller;

import java.util.Date;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("pathparam")
public class PathParamController {

	@RequestMapping("foo")
	@ResponseBody
	public String foo(@RequestHeader(value = "User-Agent") String contentType,
						@RequestHeader(value = "Content-Type", required = false) Date customerHeader){
		return String.format("Content-Type: %s, User-Agent: %s", contentType, customerHeader);
	}
	
	@RequestMapping("bar")
	@ResponseBody
	public String bar(@RequestHeader HttpHeaders httpHeaders){
		Set<String> keys = httpHeaders.keySet();
		StringBuilder sb = new StringBuilder();
		sb.append("<h1>HttpHeaders</h1>" + System.lineSeparator());
		keys.forEach(key -> sb.append(key + ": " + httpHeaders.get(key) + "<br>"));
		return sb.toString();
	}
}
