package com.srv.studentdepartment.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srv.studentdepartment.dao.StudentDao;
import com.srv.studentdepartment.entity.Student;

@Service
@Transactional
public class StudenrService_Impl implements StudentService
{
	@Autowired
	private StudentDao dao;

	@Override
	
	public Serializable saveStudent(Student student) {
		
		return dao.saveStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
	
		return dao.getAllStudents();
	}

}
