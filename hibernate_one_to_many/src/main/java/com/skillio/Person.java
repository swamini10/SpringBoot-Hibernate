package com.skillio;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Person {
	@Id
	private int id;
	private String name;
	private String address;
	
	//t0 show one to many relation we need to create list 
	@OneToMany
	private List <Document> Docs ;

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

	public List<Document> getDocs() {
		return Docs;
	}

	public void setDocs(List<Document> docs) {
		Docs = docs;
	}
	public Person() {}
	
	public Person(int id, String name, String address, List<Document> docs) {	
		this.id = id;
		this.name = name;
		this.address = address;
		Docs = docs;
	}
	
}
