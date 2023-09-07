package com.learnsphere.Entities;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Course {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;

String coursename;

int price;

@OneToMany(mappedBy = "course")
public List<Lesson> lessons;

@ManyToMany
public List<Users> users = new ArrayList<Users>();

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getCoursename() {
	return coursename;
}

public void setUser(Users users) {
    this.users.add(users);
}


public void setCoursename(String coursename) {
	this.coursename = coursename;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public List<Lesson> getLessons() {
	return lessons;
}

public void setLessons(List<Lesson> lessons) {
	this.lessons = lessons;
}

public List<Users> getUser() {
	return users;
}

public void setUser(List<Users> users) {
	this.users = null;
}

public Course(Long id, String coursename, int price, List<Lesson> lessons, List<Users> users) {
	super();
	this.id = id;
	this.coursename = coursename;
	this.price = price;
	this.lessons = lessons;
	this.users = users;
}

public Course() {
	super();
}

@Override
public String toString() {
	return "Course [id=" + id + ", coursename=" + coursename + ", price=" + price + ", lessons=" + lessons + ", user="
			+ users + "]";
}




}
