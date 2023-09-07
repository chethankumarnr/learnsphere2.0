package com.learnsphere.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnsphere.Entities.Course;
import com.learnsphere.Entities.Lesson;
import com.learnsphere.Entities.Users;
import com.learnsphere.Repositry.CourseRepo;
import com.learnsphere.Repositry.LessonRepo;
import com.learnsphere.Repositry.UserRepo;
import com.learnsphere.Sessiion.Session;

@Service
public class StudentService {

	@Autowired
	UserRepo usr;
	
	@Autowired
	CourseRepo cr;
	
	@Autowired
	LessonRepo lr;
	
	
	@Autowired
	TraineerServiceImpl cs;
	
	public List<Course> buyCoures()
	{
		return cr.findAll();
	}

	public List<Lesson> viewLessons(Long id) {
		
		return lr.findByCourse(cr.findById(id).get());
		
	}
	
	
	public Course getCourse(Long id) {
		
		
		return cr.findById(id).get();
		
	}

	public void buyCoure(Long id) {
		Course c = cr.findById(id).get();
		System.err.println(c);
		Users users = usr.findById(Session.getId()).get();
		System.err.println(users.id);
		
		
		users.setCourses(c);
		c.setUser(users);
		System.err.println(users.courses);
		System.err.println(c.users);
		usr.save(users);
		cr.save(c);
		
	}

	public List<Course> myCourses() {
		
		return usr.findById(Session.getId()).get().courses;
		
	}

	public boolean checkbought(Long id) {
		return usr.findById(Session.getId()).get().courses.contains(cr.findById(id).get());
	}
}
