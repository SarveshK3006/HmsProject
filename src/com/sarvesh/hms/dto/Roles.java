package com.sarvesh.hms.dto;

public class Roles {

	private int id ;
	private String name ;
	private String namedetails ;
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
	public String getNamedetails() {
		return namedetails;
	}
	public void setNamedetails(String namedetails) {
		this.namedetails = namedetails;
	}
	@Override
	public String toString() {
		return "Roles [id=" + id + ", name=" + name + ", namedetails=" + namedetails + "]";
	}
	
	
	
}
