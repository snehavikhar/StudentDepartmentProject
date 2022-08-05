package com.srv.studentdepartment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
public class StudentDepartmentManyToOneApplication {

	public static Logger logger=LogManager.getLogger(StudentDepartmentManyToOneApplication.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(StudentDepartmentManyToOneApplication.class, args);
		logger.info("Application Started");
	}

}
