package com.m3.welcome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.m3.dept.model.DeptService;
import com.m3.emp.model.EmpService;

@Controller
public class WelcomeController {
	@Autowired
	private EmpService empService;
	
	@Autowired
	private DeptService deptService;

	@RequestMapping(value = {"/welcome", "*"})
	public String welcomePage(Model model){
		model.addAttribute("emps", empService.findAll());
		model.addAttribute("depts", deptService.findAll());
		return "welcome";
	}
}
