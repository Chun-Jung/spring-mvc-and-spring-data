package com.m3.data.binding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.m3.example.model.UploadForm;

@Controller
@RequestMapping("databinding")
public class FormDataBindingController {
	
	@RequestMapping(value = "uploadForm", method = RequestMethod.GET)
	public String uploadFormPage(Model model){
		model.addAttribute("uploadForm", new UploadForm());
		return "databinding";
	}
	
	@RequestMapping(value = "uploadForm", method = RequestMethod.POST)
	@ResponseBody
	public String doUpload(UploadForm form){
		String msg = "";
		msg += "username:" + form.getUsername() + "<br />date:" + form.getDate();
		for(MultipartFile file : form.getFile()){
			if(file.getSize() == 0){
				continue;
			}
			msg += "<br>file.name:" + file.getOriginalFilename() + ", file.size:" + file.getSize();
		}
		return msg;
	}
}
