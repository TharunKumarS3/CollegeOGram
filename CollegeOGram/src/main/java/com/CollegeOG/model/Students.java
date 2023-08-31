package com.CollegeOG.model;

public class Students {
	
	private String name;
	private String dept;
	private String img;
	
	public Students() {
		// TODO Auto-generated constructor stub
	}
	public Students(String name, String dept, String img) {
		
		this.name = name;
		this.dept = dept;
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Students [name=" + name + ", dept=" + dept + ", img=" + img + "]";
	}
	
	
	

}
