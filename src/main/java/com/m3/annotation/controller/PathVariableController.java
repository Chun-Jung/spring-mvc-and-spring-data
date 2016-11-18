package com.m3.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m3.emp.model.Emp;
import com.m3.emp.model.EmpService;

@Controller
@RequestMapping("pathvariable")
public class PathVariableController {
	@Autowired
	private EmpService empService;

	@RequestMapping("emp/{empno:\\d+}")
	@ResponseBody
	public Emp findOneEmp(@PathVariable("empno") Integer empno){
		return empService.findOne(empno);
	}
}
