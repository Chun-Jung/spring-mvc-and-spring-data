package com.m3.dept.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.m3.dept.model.Dept;
import com.m3.dept.model.DeptRegistrationForm;
import com.m3.dept.model.DeptService;

@Controller
@RequestMapping("dept")
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping(value = "findOne", params = {"deptno"}, method = RequestMethod.POST)
	public String findOne(Integer deptno, Model model){
		Dept dept = deptService.findOne(deptno);
		if(dept == null){
			model.addAttribute("errorMsg", "查無該部門編號-" + deptno);
		}else{
			model.addAttribute(dept);
		}
		return dept == null ? "forward:/welcome" : "dept/findOneDept";
	}
	
	@RequestMapping(value = "findOne/{deptno:\\d+}")
	public String findOneByPath(@PathVariable("deptno") Integer deptno, Model model){
		return this.findOne(deptno, model);
	}
	
	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String registrationPage(Model model){
		model.addAttribute("deptForm", new DeptRegistrationForm());
		return "dept/registration";
	}
	
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String addDept(DeptRegistrationForm deptForm){
		Dept dept = new Dept();
		BeanUtils.copyProperties(deptForm, dept);
		deptService.saveOrUpdate(dept);
		return "redirect:/dept/findOne/" + dept.getDeptno();
	}
}
