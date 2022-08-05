package com.srv.studentdepartment.dao;

import java.io.Serializable;
import java.util.List;

import com.srv.studentdepartment.entity.Student;

public interface StudentDao
{
	public Serializable saveStudent(Student student);
	public List<Student> getAllStudents();

}
