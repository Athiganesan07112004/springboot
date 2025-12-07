package com.example.student1.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;



@Component
@Table(name="Student")
public class Student {
	
	private int id;
	private String name;
	private String email;
	private int age;
	
	public Student() {
		
	}

	public Student(int id, String name, String email, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	

	

}
