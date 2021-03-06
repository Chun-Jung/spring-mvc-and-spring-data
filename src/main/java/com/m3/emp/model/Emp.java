package com.m3.emp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.m3.dept.model.Dept;

@Entity
@Table(name = "emp2")
public class Emp {
	/** 員工編號 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empno;
	
	/** 員工姓名 */
	private String ename;
	
	/** 職稱 */
	private String job;
	
	/** 聘用日期 */
	private Date hiredate;
	
	/** 薪水 */
	private Double sal;
	
	/** 傭金 */
	private Double comm;
	
	/** 部門 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "deptno")
	private Dept dept;

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
