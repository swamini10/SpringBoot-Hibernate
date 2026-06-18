package com.skillio.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skillio.model.Student;

@Service
public class StudentService {
	
	public List <Student> allStudents(){
		Student s1 = new Student(1, "vinod", "vinod@gmail.com", 456, "IT", 90000, "Pune");
		Student s2 = new Student(2, "don", "don@gmail.com", 342, "HR", 8900, "Ppur");
		Student s3 = new Student(3, "shree", "shree@gmail.com", 123, "IT", 7800, "Latur");
		Student s4 = new Student(4, "Amit", "amit@gmail.com", 567, "Finance", 8500, "Mumbai");
		Student s5 = new Student(5, "Priya", "priya@gmail.com", 678, "IT", 9200, "Nagpur");
		Student s6 = new Student(6, "Rahul", "rahul@gmail.com", 789, "HR", 7600, "Nashik");
		Student s7 = new Student(7, "Sneha", "sneha@gmail.com", 890, "Marketing", 8100, "Pune");
		Student s8 = new Student(8, "Karan", "karan@gmail.com", 901, "IT", 9500, "Aurangabad");
		Student s9 = new Student(9, "Neha", "neha@gmail.com", 112, "Finance", 7000, "Solapur");
		Student s10 = new Student(10, "Rohit", "rohit@gmail.com", 223, "HR", 8800, "Kolhapur");
		Student s11 = new Student(11, "Anjali", "anjali@gmail.com", 334, "IT", 9700, "Satara");
		Student s12 = new Student(12, "Vikas", "vikas@gmail.com", 445, "Marketing", 8300, "Sangli");
		Student s13 = new Student(13, "Pooja", "pooja@gmail.com", 556, "Finance", 7900, "Jalgaon");

		return Arrays.asList(s1, s2, s3, s4, s5, s6, s7,s8, s9, s10, s11, s12, s13);
	}
	
	
     public Student getStudent(String email) {
    	 //allStudents();
    	 
    	 //main logic 
    	 
    	 for(Student stu : allStudents()) {
    		 if(stu.getEmail().equals(email)) {
    			 return stu;
    		 }
    	 }
    	 return new Student();
     }

	
}
