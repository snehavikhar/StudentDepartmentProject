package com.srv.studentdepartment.service;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srv.studentdepartment.dao.DepartmentDao;
import com.srv.studentdepartment.entity.Department;

@Service
@Transactional
public class DepartmentService_Impl implements DepartmentService 
{
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public Serializable saveDepartment(Department department) 
	{
		return departmentDao.saveDepartment(department);
	}

}
