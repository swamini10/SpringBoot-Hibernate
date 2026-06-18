package com.skillio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.skillio.model.Student;
import com.skillio.service.StudentService;

@RestController
public class StudentController {
	
// for testing purpose
	@GetMapping("/data")
	public String data() {
		return "wooow";
	}
	
	// method call karychi object create karycha kute class level la 
	@Autowired
	StudentService ss;
	// we can do this using path variable 
	@GetMapping("/Student/{email}")
	public Student getStudentByEmail(@PathVariable("email") String email) {
		return ss.getStudent(email);
	}
	// create and dummy data of student in service file 
	
	
	
	
	
}
