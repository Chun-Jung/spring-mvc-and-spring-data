package com.m3.returntypes.controller;

import java.util.Date;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.m3.example.model.UploadForm;

@Controller
@RequestMapping("returntypes")
public class ReturnTypesController {
	

	@RequestMapping("model")
	public ModelMap model(ModelMap modelMap){
		UploadForm form = new UploadForm();
		form.setUsername("m3_user_modelMap");
		form.setDate(new Date());
		modelMap.addAttribute("form", form);
		modelMap.addAttribute("message", "Hello Spring MVC! ModelMap");
		return modelMap;
	}
	
	@RequestMapping("view")
	public View view(){
//		View view = new RedirectView("https://www.yahoo.com.tw");
//		View view = new RedirectView("model");
//		View view = new RedirectView("/returntypes/model");
		View view = new RedirectView("/returntypes/model", true);
		return view;
	}
	
	@RequestMapping("modelAndView")
	public ModelAndView modelAndView(){
		ModelAndView view = new ModelAndView();
		view.addObject("message", "Hello World");
		view.addObject("username", "m3_user_modelAndView");
		view.setViewName("forward:/requestparam/bar");
		return view;
	}
	
	@RequestMapping("responsebody")
	public HttpEntity<?> responsebody(){
		return ResponseEntity.status(HttpStatus.SEE_OTHER).header(HttpHeaders.LOCATION, "returntypes/model").build();
	}
	
	@RequestMapping("any")
	public String any(){
		return null;
	}
}
