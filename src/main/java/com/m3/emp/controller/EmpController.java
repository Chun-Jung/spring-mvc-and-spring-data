package com.m3.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.m3.dept.model.DeptService;
import com.m3.emp.model.Emp;
import com.m3.emp.model.EmpService;

@Controller
@RequestMapping("emp")
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@Autowired
	private DeptService deptService;

	@RequestMapping(value = "findOne", params = {"empno"}, method = RequestMethod.POST)
	public String findOne(Integer empno, Model model){
		Emp emp = empService.findOne(empno);
		if(emp == null){
			model.addAttribute("errorMsg", "查無該部門編號-" + empno);
		}else{
			model.addAttribute(emp);
		}
		return emp == null ? "forward:/welcome" : "dept/findOneEmp";
	}
	
	@RequestMapping(value = "findOne/{empno:\\d+}")
	public String findOneByPath(@PathVariable("empno") Integer empno, Model model){
		return this.findOne(empno, model);
	}
	
	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String registrationPage(Model model){
		model.addAttribute("emp", new Emp());
		model.addAttribute("depts", deptService.findAll());
		return "emp/registration";
	}
	
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String addEmp(Emp emp){
		empService.saveOrUpdate(emp);
		return "redirect:/emp/findOne" + emp.getEmpno();
	}
	
}
