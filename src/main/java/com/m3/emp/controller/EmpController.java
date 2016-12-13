package com.m3.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
			model.addAttribute("errorMsg", "查無該員工編號-" + empno);
		}else{
			model.addAttribute(emp);
		}
		return emp == null ? "forward:/welcome" : "emp/findOneEmp";
	}
	
	@RequestMapping(value = "findOne/{empno:\\d+}")
	public String findOneByPath(@PathVariable("empno") Integer empno, Model model){
		return this.findOne(empno, model);
	}
	
	@RequestMapping(value = "findAllEmps", method = RequestMethod.GET)
	public Model findAllEmps(Model model){
		model.addAttribute("emps", empService.findAll());
		return model;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addEmpPage(Model model){
		model.addAttribute("empForm", new Emp());
		model.addAttribute("depts", deptService.findAll());
		model.addAttribute("title", "Emp add page");
		return "emp/empModify";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addEmp(Emp emp){
		empService.saveOrUpdate(emp);
		return "redirect:/emp/findOne/" + emp.getEmpno();
	}
	
	@RequestMapping(value = "modify/{empno:\\d+}", method = RequestMethod.GET)
	public String modifyEmpPage(@PathVariable("empno") Integer empno,Model model){
		Emp emp = empService.findOne(empno);
		if(emp == null){
			model.addAttribute("errorMsg", "查無該員工編號-" + empno);
			return "forward:/welcome";
		}
		
		model.addAttribute("empForm", emp);
		model.addAttribute("depts", deptService.findAll());
		model.addAttribute("title", "Emp modify page");
		return "emp/empModify";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modifyEmp(Emp emp){
		empService.saveOrUpdate(emp);
		return "redirect:/emp/findOne/" + emp.getEmpno();
	}
	
	@RequestMapping(value = "deleteOne/{empno:\\d+}", method = RequestMethod.DELETE)
	public HttpEntity<Emp> deleteOneEmp(@PathVariable("empno") Integer empno){
		Emp emp = empService.findOne(empno);
		if(emp == null){
			return new ResponseEntity<Emp>(HttpStatus.NOT_FOUND);
		}
		
		empService.delete(emp);
		return new ResponseEntity<Emp>(HttpStatus.NO_CONTENT);
	}
}
