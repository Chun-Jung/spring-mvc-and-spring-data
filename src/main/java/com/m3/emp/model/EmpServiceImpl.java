package com.m3.emp.model;

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
	public void findOne(Integer empno) {
		empDao.findOne(empno);
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

}
