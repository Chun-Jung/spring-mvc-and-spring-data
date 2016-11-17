package com.m3.dept.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.m3.emp.model.Emp;

@Entity
@Table(name = "dept2")
public class Dept {
	/** 部門編號 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deptno;
	
	/** 部門名稱 */
	private String dname;
	
	/** 部門地點 */
	private String loc;
	
	/** 部門下的所有員工 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dept")
	private Collection<Emp> emps;
	
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
