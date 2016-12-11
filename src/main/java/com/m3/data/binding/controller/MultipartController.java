package com.m3.data.binding.controller;

import java.util.List;

import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("multipart")
public class MultipartController {

	@RequestMapping(value = "uploadPage", method = RequestMethod.GET)
	public String uploadPage(){
		return "multipart";
	}
	
	@RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
	@ResponseBody
	public String doUpload(@RequestParam("username") String username, @RequestPart("upload") Part upload){
		String msg = "username: " + username;
		msg += "<br />upload.name: " + upload.getName() + ", upload.submittedFileName: " + upload.getSubmittedFileName() + ", upload.size: " + upload.getSize();
		return msg;
	}
	
	@RequestMapping(value = "uploads", method = RequestMethod.POST)
	@ResponseBody
	public String doUploads(@RequestParam("username") String username, @RequestParam("upload") List<MultipartFile> uploads){
		String msg = "username: " + username;
		for(MultipartFile upload : uploads){
			if(StringUtils.isBlank(upload.getOriginalFilename())){
				continue;
			}
			msg += "<br />upload.name: " + upload.getName() + ", upload.originalFilename: " + upload.getOriginalFilename() + ", upload.size: " + upload.getSize();
		}
		return msg;
	}
}
