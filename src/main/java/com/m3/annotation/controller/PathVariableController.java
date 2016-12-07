package com.m3.annotation.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m3.emp.model.Emp;
import com.m3.emp.model.EmpService;
import com.m3.utils.DateUtils;

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
	
	@RequestMapping("emp/hiredate/{year:\\d+}")
	@ResponseBody
	public Iterable<Emp> findByYear(@PathVariable Map<String, String> map){
		Integer year = Integer.valueOf(map.get("year"));
		
		Date startDt = DateUtils.getStartDateOfYear(year);
		Date endDt = DateUtils.getEndDateOfYear(year);
		
		Iterable<Emp> emps = empService.findByHiredateBetween(startDt, endDt);
		
		return emps;
	}
	
	@RequestMapping("emp/hiredate/{year:\\d+}/{month:\\d+}")
	@ResponseBody
	public Iterable<Emp> findByYearMonth(@PathVariable Map<String, String> map){
		Integer year = Integer.valueOf(map.get("year"));
		Integer month = Integer.valueOf(map.get("month"));
		
		Date startDt = DateUtils.getStartDateOfYear(year);
		Date endDt = DateUtils.getEndDateOfYear(year);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDt);
		calendar.set(Calendar.MONTH, month - 1);
		startDt = calendar.getTime();
		
		calendar.setTime(endDt);
		calendar.set(Calendar.MONTH, month - 1);
		endDt = calendar.getTime();
		
		Iterable<Emp> emps = empService.findByHiredateBetween(startDt, endDt);
		
		return emps;
	}
	
	@RequestMapping("emp/hiredate/{year:\\d+}/{month:\\d+}/{date:\\d+}")
	@ResponseBody
	public Iterable<Emp> findByDate(@PathVariable Map<String, String> map){
		Integer year = Integer.valueOf(map.get("year"));
		Integer month = Integer.valueOf(map.get("month"));
		Integer date = Integer.valueOf(map.get("date"));
		
		Date startDt = DateUtils.getStartDateOfYear(year);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDt);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, date);
		startDt = calendar.getTime();
		
		Iterable<Emp> emps = empService.findByHiredateBetween(startDt, startDt);
		
		return emps;
	}
}
