package com.srv.studentdepartment.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srv.studentdepartment.entity.Student;


@Repository

public class StudentDao_Impl implements StudentDao
{
	
	@Autowired
	SessionFactory factory;
	Session session;

	@Override
	public Serializable saveStudent(Student student) 
	{
		
		//Transaction transaction =session.beginTransaction();;
		Serializable id=null;
		try
		{
			Student s=null;
			Criteria criteria=factory.getCurrentSession().createCriteria(Student.class);
			criteria.add(Restrictions.eq("enrollment_no", student.getEnrollment_no()));
			s=(Student) criteria.uniqueResult();
			if(s==null)
			{
				id=factory.getCurrentSession().save(student);
				//transaction.commit();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return id;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students=null;
		try
		{
			Criteria criteria=factory.getCurrentSession().createCriteria(Student.class);
			students=criteria.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return students;
	}

}
