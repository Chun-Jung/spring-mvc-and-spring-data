package com.m3.dept.model;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface DeptDao extends CrudRepository<Dept, Integer> {
	/**
	 * 依部門名稱搜尋部門
	 * @param dname 部門名稱
	 * @return Collection<Dept>
	 */
	public Collection<Dept> findByDname(String dname);
}
