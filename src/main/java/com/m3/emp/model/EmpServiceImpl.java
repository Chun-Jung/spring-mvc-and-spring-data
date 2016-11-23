package com.m3.emp.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("empService")
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpDao empDao;

	@Override
	@Transactional
	public void saveOrUpdate(Emp emp) {
		empDao.save(emp);
	}

	@Override
	@Transactional(readOnly = true)
	public Emp findOne(Integer empno) {
		return empDao.findOne(empno);
	}

	@Override
	@Transactional
	public void delete(Emp emp) {
		empDao.delete(emp);
	}

	@Override
	@Transactional
	public void delete(Integer empno) {
		empDao.delete(empno);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Emp> findAll() {
		return empDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Emp> findByHiredateBetween(Date startDt, Date endDt){
		return empDao.findByHiredateBetween(startDt, endDt);
	}
}
