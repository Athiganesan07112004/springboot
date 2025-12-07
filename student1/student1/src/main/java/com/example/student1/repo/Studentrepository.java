package com.example.student1.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;


import com.example.student1.model.Student;


@Repository
public class Studentrepository {
	
	
	    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
	    private static final String USER = "root";
	    private static final String PASS = "athi@123";


	public Student findbyid(int id) {
		   Student s=null;
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps=c.prepareStatement("select * from student where id=?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
		    s=new Student();
		   s.setId(rs.getInt("id"));
			  s.setName(rs.getString("name"));
			  s.setEmail(rs.getString("email"));
			  s.setAge(rs.getInt("age"));
			 
		}else {
			System.out.println("student not found");
		}
			
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return s;

}
	
	public int updatestudent(int id,Student s) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps=c.prepareStatement("update student set name=?,email=?,age=? where id=?");
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setInt(3, s.getAge());
			ps.setInt(4, id);
			return ps.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public int deletestudent(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps=c.prepareStatement("delete from student where id=?");
			
			ps.setInt(1, id);
			
			return ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	public List<Student> findAll(){
		List<Student> list=new ArrayList<Student>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps=c.prepareStatement("select * from student");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Student s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setAge(rs.getInt("age"));
				
				list.add(s);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	
	public int addStudent(Student s) {
		  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = c.prepareStatement("INSERT INTO student(name, email, age) VALUES (?, ?, ?)");
			
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setInt(3, s.getAge());

			
			 return ps.executeUpdate();
			
			
		}catch (Exception e) {
		   e.printStackTrace();
		  return 0;
		}
		
	}
 
	public int updatestudentname(int id, String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps=c.prepareStatement("update student set name=? where id=?");
			ps.setString(1, name);
		
			ps.setInt(2, id);
			return ps.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	

}
