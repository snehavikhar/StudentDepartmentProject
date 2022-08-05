package com.srv.studentdepartment.dao;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srv.studentdepartment.entity.Department;

@Repository
public class DepartmentDao_Impl implements DepartmentDao 
{
	
	@Autowired
	private SessionFactory factory;
	//private Session session;

	@Override
	public Serializable saveDepartment(Department department) 
	{
		Serializable serializable=null;
		try
		{
			Department d=null;
			Criteria criteria=factory.getCurrentSession().createCriteria(Department.class);
			criteria.add(Restrictions.eq("department_id", department.getDepartment_id()));
			d=(Department) criteria.uniqueResult();
			
			if(d==null)
			{
				serializable=factory.getCurrentSession().save(department);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return serializable;
	}

}
