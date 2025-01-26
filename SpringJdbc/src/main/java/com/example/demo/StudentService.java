package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	StudentRepo repo;
	public StudentRepo getRepo() {
		return repo;
	}
	@Autowired
	public void setRepo(StudentRepo repo) {
		this.repo = repo;
	}
	public void addStudent(Student stud) {
		//System.out.println("Student addded successfully...");
		repo.save(stud);
	}
	public List<Student> getStudent(){
		return  repo.findAll();
	}
	
}
