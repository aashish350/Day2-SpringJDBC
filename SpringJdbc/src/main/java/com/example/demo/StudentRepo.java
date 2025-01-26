package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {
	@Autowired
  private	JdbcTemplate temp;

	public JdbcTemplate getTemp() {
		return temp;
	}
   
	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}

	public void save(Student stud) {
		// TODO Auto-generated method stub
//		String sql="insert into Student(id,name,year) values(?,?,?)";
		String sql="insert into student(id,name,marks) values(?,?,?)";
		int row=temp.update(sql,stud.getId(),stud.getName(),stud.getMarks());
		System.out.println(row+"is affected...");
		System.out.println("student data is saved...");
	}

	public List<Student> findAll() {
		// TODO Auto-generated method stub
		String sql="select * from Student";
		RowMapper<Student> mapper=new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setMarks(rs.getInt("marks"));
				return s;
			}
			
		};
		return temp.query(sql,mapper);
	}
   
}
