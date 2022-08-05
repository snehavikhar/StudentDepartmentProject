package com.srv.studentdepartment.service;

import java.io.Serializable;
import java.util.List;

import com.srv.studentdepartment.entity.Student;

public interface StudentService
{
	public Serializable saveStudent(Student student);
	public List<Student> getAllStudents();

}
