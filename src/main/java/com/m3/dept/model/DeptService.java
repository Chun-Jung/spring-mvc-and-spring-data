package com.m3.dept.model;

import java.util.Collection;

public interface DeptService {
	/**
	 * 新增或修改
	 * @param dept 部門
	 */
	public void saveOrUpdate(Dept dept);
	
	/**
	 * 查詢一個部門
	 * @param deptno 部門編號
	 * @return Dept
	 */
	public Dept findOne(Integer deptno);
	
	/**
	 * 刪除
	 * @param dept 部門
	 */
	public void delete(Dept dept);
	
	/**
	 * 刪除
	 * @param deptno 部門編號
	 */
	public void delete(Integer deptno);
	
	/**
	 * 依部門名稱搜尋部門
	 * @param dname 部門名稱
	 * @return Collection<Dept>
	 */
	public Collection<Dept> findByDname(String dname);
}
