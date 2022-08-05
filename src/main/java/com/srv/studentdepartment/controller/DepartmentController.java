package com.srv.studentdepartment.controller;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srv.studentdepartment.entity.Department;
import com.srv.studentdepartment.service.DepartmentService;

@RestController
@RequestMapping(value="/department")
public class DepartmentController 
{
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping(value="/save")
	public ResponseEntity<Object> saveDepartment(@Valid @RequestBody Department department)
	{
		Serializable serializable=departmentService.saveDepartment(department);
		if(serializable!=null)
		{
			return new ResponseEntity<Object>("Department added!!",HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Object>("Department already exist",HttpStatus.CONFLICT);
		}
	}
	

}
