package com.m3.emp.model;

import java.util.Date;

public interface EmpService {
	/**
	 * 新增或更新員工
	 * @param emp 員工
	 */
	void saveOrUpdate(Emp emp);
	
	/**
	 * 查詢一個員工
	 * @param empno 員工編號
	 */
	Emp findOne(Integer empno);
	
	/**
	 * 刪除員工
	 * @param emp 員工
	 */
	void delete(Emp emp);
	
	/**
	 * 刪除員工
	 * @param empno 員工編號
	 */
	void delete(Integer empno);
	
	/**
	 * 找出所有的員工
	 * @return Collection<Emp>
	 */
	Iterable<Emp> findAll();
	
	/**
	 * 查詢日期內到職的員工
	 * @param startDt 聘用日期起日
	 * @param endDt 聘用日期訖日
	 * @return Iterable<Emp>
	 */
	Iterable<Emp> findByHiredateBetween(Date startDt, Date endDt);
}
