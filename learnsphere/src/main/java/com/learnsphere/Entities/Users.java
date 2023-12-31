package com.learnsphere.Entities;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity

public class Users {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Long id;

@Column(name = "FirstName")
 String fname;

@Column(name="LastName")
String lname;

 String email;
public String mobileno;
public String role;
public String password;

@ManyToMany(mappedBy = "users")
public List<Course> courses = new ArrayList<Course>();

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMobileno() {
	return mobileno;
}

public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public List<Course> getCourses() {
	return courses;
}

public void setCourses(List<Course> courses) {
	this.courses = courses;
}




public void setCourses(Course courses) {
	this.courses.add(courses);
}

public Users(Long id, String fname, String lname, String email, String mobileno, String role, String password,
		List<Course> courses) {
	super();
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.email = email;
	this.mobileno = mobileno;
	this.role = role;
	this.password = password;
	this.courses = courses;
}

public Users() {
	super();
}



}
