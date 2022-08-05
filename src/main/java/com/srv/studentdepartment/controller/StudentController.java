package com.srv.studentdepartment.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srv.studentdepartment.entity.Student;
import com.srv.studentdepartment.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping(value="/student")
public class StudentController 
{
	@Autowired(required = true)
	private StudentService service;
	
	@PostMapping(value="/save")
	public ResponseEntity<Object> saveStudent(@Valid @RequestBody Student student)
	{
		Serializable serializable=service.saveStudent(student);
		if(serializable!=null)
		{
			return new ResponseEntity<Object>("Student addd!!",HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Object>("Student already exist!!",HttpStatus.CONFLICT); 
		}
	}
	
	@GetMapping(value="/getallstudents")
	public ResponseEntity<List<Student>> getAllStudents()
	{
		List<Student> students=service.getAllStudents();
		if(!students.isEmpty())
		{
			return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
	}
	

}
