package com.m3.data.binding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m3.dept.model.DeptService;
import com.m3.emp.model.EmpRegistrationForm;

@Controller
@RequestMapping("databinding")
public class FormDataBindingController {
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping(value = "emp", method = RequestMethod.GET)
	public String empRegistrationPage(Model model){
		model.addAttribute("depts", deptService.findAll());
		model.addAttribute("empForm", new EmpRegistrationForm());
		return "emp_registration";
	}
	
	@RequestMapping(value = "emp", method = RequestMethod.POST)
	@ResponseBody
	public EmpRegistrationForm empRegistration(EmpRegistrationForm empForm){
		return empForm;
	}
}
