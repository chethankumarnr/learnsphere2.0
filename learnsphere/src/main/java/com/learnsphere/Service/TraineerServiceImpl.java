package com.learnsphere.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnsphere.Entities.Course;
import com.learnsphere.Entities.Lesson;
import com.learnsphere.Entities.Users;
import com.learnsphere.Repositry.CourseRepo;
import com.learnsphere.Repositry.LessonRepo;
import com.learnsphere.Repositry.UserRepo;

@Service
public class TraineerServiceImpl implements TraineerService {
@Autowired
CourseRepo cr;

@Autowired
LessonRepo lr;

@Autowired
UserRepo usr;



public void addCourse(Course course)
{
	System.out.println(course.toString());
	cr.save(course);
	
}

public void addLessson(Lesson lesson) {
	
	lr.save(lesson);
}


public List<Course> getCourses(Long id)
{
	System.out.println(usr.findById(id).get().getCourses());
	return usr.findById(id).get().getCourses();
	
}



public Course getCourseById(Long courseid) {
	return cr.findById(courseid).get();
	
}

@Transactional
public void delete(Long id) {
	try {
			lr.deleteByCourse(cr.findById(id).get());
			cr.delete(cr.findById(id).get());
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
}

public void deleteLesson(long lessonId) {
	lr.deleteById(lessonId);
}

public void updateLesson(Lesson lesson) {
	Lesson lsn = lr.findById(lesson.LessonId).get();
	lsn.setLink(lesson.getLink());
	lsn.setTopics(lesson.getTopics());
	lr.save(lsn);
}

public Users getUserById(Long id) {
	
	return usr.findById(id).get();
}





}
