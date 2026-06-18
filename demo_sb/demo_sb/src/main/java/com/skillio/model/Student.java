package com.skillio.model;

public class Student {
			private int id;
			private String name;
			private String email;
			private int mobile;
			private String dept;
			private int fee;
			private String address;
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
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
			public int getMobile() {
				return mobile;
			}
			public void setMobile(int mobile) {
				this.mobile = mobile;
			}
			public String getDept() {
				return dept;
			}
			public void setDept(String dept) {
				this.dept = dept;
			}
			public int getFee() {
				return fee;
			}
			public void setFee(int fee) {
				this.fee = fee;
			}
			public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public Student() {
				super();
				// TODO Auto-generated constructor stub
			}
			public Student(int id, String name, String email, int mobile, String dept, int fee, String address) {
				this.id = id;
				this.name = name;
				this.email = email;
				this.mobile = mobile;
				this.dept = dept;
				this.fee = fee;
				this.address = address;
			}
			
			
			
			
}
