package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringJdbcApplication.class, args);
		Student stud=context.getBean(Student.class);
		stud.setId(4);
		stud.setName("Anna");
		stud.setMarks(2024);
		StudentService ser=context.getBean(StudentService.class);
		ser.addStudent(stud);
		List<Student> s=ser.getStudent();
		System.out.println(s);
		System.out.println(ser.getStudent());
	}

}
