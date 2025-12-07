package com.example.student1.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student1.model.Student;
import com.example.student1.model.StudentnotfoundException;
import com.example.student1.repo.Studentrepository;
@Service
public class studentservice {
	
	@Autowired
	private  Studentrepository repo;

	

	public String updateStudentbyid(int id, Student student) {
		
		int updatestudent=repo.updatestudent(id,student);
		
	
		
		
		
		
		
		 if (updatestudent == 0) {
		         throw new StudentnotfoundException("student"+id +"not found");
		    } else {
		        return "Student updated sucessfully";
		    }
		
	   
		

	
		
	}

	public List<Student> getallStudent() {
		List<Student> students=repo.findAll();
		if(students.isEmpty()) {
			throw new StudentnotfoundException("student data found");
		}
		return students;
	}

	public int addStudent(Student student) {
		if (student.getName()==null) {
			throw new   StudentnotfoundException("name is required");
		}
		if (student.getEmail()==null) {
			throw new   StudentnotfoundException("Email is required");
		}
		if (student.getAge()==0) {
			throw new   StudentnotfoundException("Age is required");
		}
		
		return repo.addStudent(student);
	
		
		
		
		
		
				 
	}


	public Student getStudentbyid(int id) {
		Student student =repo.findbyid(id);
		if(student==null) {
			throw new StudentnotfoundException("student not found");
		}
		return student;
	}

	public String deletestudent(int id) {
		int res=repo.deletestudent(id);
		if(res>0)
			return "student deleted sucessfully";
		else
			return "student not found";
	}

	public String updatename(int id, String name) {
		
		int updatestudentname=repo.updatestudentname(id,name);
		
		
		
		
		
		
		
		 if (updatestudentname == 0) {
		         throw new StudentnotfoundException("student"+id +"not found");
		    } else {
		        return "Student name updated sucessfully";
		    
		
	}

}
}
