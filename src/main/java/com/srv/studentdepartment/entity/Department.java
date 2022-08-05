package com.srv.studentdepartment.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Department 
{
	
	@Id
	@NotNull(message="department_id can NOT be null")
	private String department_id;
	
	@NotNull(message="department_name can NOT be null")
	private String department_name;

	public Department() {
		super();
	}

	public Department(@NotNull(message = "department_id can NOT be null") String department_id,
			@NotNull(message = "department_name can NOT be null") String department_name) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name + "]";
	}
	
	
	
	

	
	

}
