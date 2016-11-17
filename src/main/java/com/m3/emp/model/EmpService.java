package com.m3.emp.model;

public interface EmpService {
	/**
	 * 新增或更新員工
	 * @param emp 員工
	 */
	public void saveOrUpdate(Emp emp);
	
	/**
	 * 查詢一個員工
	 * @param empno 員工編號
	 */
	public void findOne(Integer empno);
	
	/**
	 * 刪除員工
	 * @param emp 員工
	 */
	public void delete(Emp emp);
	
	/**
	 * 刪除員工
	 * @param empno 員工編號
	 */
	public void delete(Integer empno);
}
