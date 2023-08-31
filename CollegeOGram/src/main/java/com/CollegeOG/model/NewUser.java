package com.CollegeOG.model;

public class NewUser {

	private String email;
	private String pass;
	private String cpass;
	private String name;
	private String dept;
	private String img;
	public NewUser() {
		
	}
	
	public NewUser(String email, String pass, String cpass, String name, String dept, String img) {
		
		this.email = email;
		this.pass = pass;
		this.cpass = cpass;
		this.name = name;
		this.dept = dept;
		this.img = img;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
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
		
	
}
