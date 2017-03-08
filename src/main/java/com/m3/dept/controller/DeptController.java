package com.m3.dept.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	@RequestMapping(value = "findAllDepts", method = RequestMethod.GET)
	public String findAllDepts(Model model){
		model.addAttribute("depts", deptService.findAll());
		return "dept/findAllDepts";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addDeptPage(Model model){
		model.addAttribute("deptForm", new DeptRegistrationForm());
		model.addAttribute("title", "Dept add page");
		return "dept/deptModify";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addDept(DeptRegistrationForm deptForm){
		Dept dept = new Dept();
		BeanUtils.copyProperties(deptForm, dept);
		deptService.saveOrUpdate(dept);
		return "redirect:/dept/findOne/" + dept.getDeptno();
	}
	
	@RequestMapping(value = "modify/{deptno:\\d+}", method = RequestMethod.GET)
	public String modifyDeptPage(@PathVariable("deptno") Integer deptno, Model model){
		Dept dept = deptService.findOne(deptno);
		if(dept == null){
			model.addAttribute("errorMsg", "查無該部門編號-" + deptno);
			return "forward:/welcome";
		}
		
		model.addAttribute("deptForm", dept);
		model.addAttribute("title", "Dept modify page");
		return "dept/deptModify";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modifyDept(Dept dept, @RequestHeader(name = "Referer", required = false) String referer){
		deptService.saveOrUpdate(dept);
		return "redirect:/dept/findOne/" + dept.getDeptno();
	}
	
	@RequestMapping("deleteOne/{deptno:\\d+}")
	public HttpEntity<Dept> deleteOneDept(@PathVariable("deptno") Integer deptno){
		Dept dept = deptService.findOne(deptno);
		if(dept == null){
			return new ResponseEntity<Dept>(HttpStatus.NOT_FOUND);
		}
		
		deptService.delete(dept);
		return new ResponseEntity<Dept>(HttpStatus.NO_CONTENT);
	}
}
