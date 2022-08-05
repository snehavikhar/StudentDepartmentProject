package com.srv.studentdepartment.dao;

import java.io.Serializable;

import com.srv.studentdepartment.entity.Department;

public interface DepartmentDao
{
	public Serializable saveDepartment(Department department);
	

}
