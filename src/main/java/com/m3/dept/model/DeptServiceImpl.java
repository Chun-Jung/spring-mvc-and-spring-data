package com.m3.dept.model;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;

	@Override
	@Transactional
	public void saveOrUpdate(Dept dept) {
		deptDao.save(dept);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Dept findOne(Integer deptno) {
		return deptDao.findOne(deptno);
	}

	@Override
	@Transactional
	public void delete(Dept dept) {
		deptDao.delete(dept);
	}

	@Override
	@Transactional
	public void delete(Integer deptno) {
		deptDao.delete(deptno);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Collection<Dept> findByDname(String dname) {
		return deptDao.findByDname(dname);
	}

}
