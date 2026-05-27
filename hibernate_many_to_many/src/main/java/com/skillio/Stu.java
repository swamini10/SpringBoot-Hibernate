package com.skillio;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Stu {
	@Id
	private int id;
	private String name;
	private String address;
	
	//t0 show one to many relation we need to create list 
	@ManyToMany
	private List <Doc> Docs ;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Doc> getDocs() {
		return Docs;
	}

	public void setDocs(List<Doc> docs) {
		Docs = docs;
	}
	public Stu() {}
	
	public Stu(int id, String name, String address, List<Doc> docs) {	
		this.id = id;
		this.name = name;
		this.address = address;
		Docs = docs;
	}
	
}
