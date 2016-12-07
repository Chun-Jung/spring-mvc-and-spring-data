package com.m3.emp.model;

import java.util.Date;

public class EmpRegistrationForm {
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
	
	/** 部門編號 */
	private Integer deptno;

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

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

}
