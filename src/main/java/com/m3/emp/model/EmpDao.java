package com.m3.emp.model;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface EmpDao extends CrudRepository<Emp, Integer> {
	/**
	 * 查詢日期內到職的員工
	 * @param startDt 聘用日期起日
	 * @param endDt 聘用日期訖日
	 * @return Iterable<Emp>
	 */
	Iterable<Emp> findByHiredateBetween(Date startDt, Date endDt);
}
