package com.srv.studentdepartment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name="Student")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "stud_seq")
	@GenericGenerator(
			name="stud_seq", 
		  //  strategy = "org.thoughts.on.java.generators.StringPrefixedSequenceIdGenerator", 
			strategy="com.srv.studentdepartment.entity.StringPrefixedSequenceIdGenerator",
	parameters = {
			@Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,value = "200"),
	
		    @Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,value ="stud_" ),
		    
			@Parameter(name=StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,value ="%05d")
	})
	private String id;

	@Column(unique = true)
	@NotNull(message="enrollment_no can NOT be null")
	private Integer enrollment_no;
	
	@NotNull(message="name can NOT be null")
	private String name;
	
	
	@ManyToOne(targetEntity = Department.class, fetch = FetchType.EAGER)
	@JoinColumn(name="department_id")
	private Department department;
	
	@NotNull(message="gender can NOT be null")
	private String gender;

	public Student() {
		super();
	}

	
	public Student(String id, @NotNull(message = "enrollment_no can NOT be null") Integer enrollment_no,
			@NotNull(message = "name can NOT be null") String name,
			@NotNull(message = "department can NOT be null") Department department,
			@NotNull(message = "gender can NOT be null") String gender) {
		super();
		this.id = id;
		this.enrollment_no = enrollment_no;
		this.name = name;
		this.department = department;
		this.gender = gender;
	}


	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Integer getEnrollment_no() {
		return enrollment_no;
	}


	public void setEnrollment_no(Integer enrollment_no) {
		this.enrollment_no = enrollment_no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", enrollment_no=" + enrollment_no + ", name=" + name + ", department="
				+ department + ", gender=" + gender + "]";
	}

	
	
	



}
