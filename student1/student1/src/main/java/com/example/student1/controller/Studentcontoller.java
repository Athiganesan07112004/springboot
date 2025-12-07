package com.example.student1.controller;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student1.model.Student;
import com.example.student1.model.StudentnotfoundException;

import com.example.student1.service.studentservice;
@RestController
public class Studentcontoller {
	
	@Autowired
	private studentservice service;
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentbyid(@PathVariable int id){
		try {
			Student student=service.getStudentbyid(id);
			return new  ResponseEntity<>(student,HttpStatus.OK);
		
		}catch(StudentnotfoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			
		}
	}
	
	@PostMapping("/{id}/update")
	public  ResponseEntity<?> updateStudent(@PathVariable int id,@RequestBody Student student){
		try {
			String updated=service.updateStudentbyid(id,student);
			return new ResponseEntity<>(updated,HttpStatus.OK);
			
		}catch (StudentnotfoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
			// TODO: handle exception
		}
	}
	@GetMapping("/student")
	public ResponseEntity<?> getallStudent(){
		try {
			List<Student> list=service.getallStudent();
			return ResponseEntity.ok(list);
			
		}catch(StudentnotfoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	
	@PostMapping("/add")
	public ResponseEntity<?>  addStudent(RequestEntity<Student> s){
	
		try {
			Student student=s.getBody();
			int addstudent=service.addStudent(student);
			return ResponseEntity.status(HttpStatus.CREATED).body(addstudent);
		}catch(StudentnotfoundException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public  String deleteStudent(@PathVariable int id) {
		try {
			return service.deletestudent(id);
			
			
		}catch(StudentnotfoundException e) {
			return null;
		}
	
	}
	
	@PutMapping("/updatename/{id}")
	public ResponseEntity<?>  updatename(@PathVariable int id,@RequestParam String name){
		try {
			String updatedname =service.updatename(id,name);
			return  new ResponseEntity<>(updatedname,HttpStatus.OK);
		}catch(StudentnotfoundException e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
}
