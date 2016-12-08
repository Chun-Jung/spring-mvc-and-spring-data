package com.m3.dept.model;

public class DeptRegistrationForm {
	/** 部門編號 */
	private Integer deptno;
	
	/** 部門名稱 */
	private String dname;
	
	/** 部門地點 */
	private String loc;

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
}
