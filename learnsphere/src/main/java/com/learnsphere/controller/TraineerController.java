package com.learnsphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnsphere.Entities.Course;
import com.learnsphere.Entities.Lesson;
import com.learnsphere.Service.CommentsService;
import com.learnsphere.Service.TraineerServiceImpl;
import com.learnsphere.Sessiion.Session;

@Controller
public class TraineerController {
	@Autowired
	TraineerServiceImpl cs;

	@Autowired
	CommentsService cms;

	@GetMapping(value="/addcourse")
	public String addCourse(Model model)
	{
		if(Session.check()==false)
			return "login";
		return "addcourse";
	}

	@PostMapping(value="/addcoursetodb")
	public String addcourseDB(@ModelAttribute Course course,Model model)
	{
		if(Session.check()==false)
			return "login";
		course.setUser(cs.getUserById(Session.getId()));
		cs.addCourse(course);
		model.addAttribute("msg", "Course Added Successfully...");

		return "addcourse";
	}

	@PostMapping(value="/addcoursetodbviaview")
	public String addcourseDB2(@ModelAttribute Course course,Model model)
	{
		if(Session.check()==false)
			return "login";
		course.setUser(cs.getUserById(Session.getId()));
		cs.addCourse(course);
		model.addAttribute("msg", "Course Added Successfully...");
		return "redirect:/viewcourse";
	}

	@GetMapping(value="/addlesson")
	public String addLesson()
	{
		if(Session.check()==false) {
			System.out.println(Session.check());
			return "login";
		}
		return "addlesson";
	}


	@PostMapping(value="/addlessontodb")
	public String addlessonDB(@ModelAttribute Lesson lesson,Model model,@RequestParam("courseid") Long courseid)
	{
		if(Session.check()==false)
			return "login";
		lesson.setCourse( cs.getCourseById(courseid));
		//System.out.print("My value "+lesson.course.toString());
		cs.addLessson(lesson);
		model.addAttribute("msg","Lesson Added Sucessfully..");
		return "addlesson";
	}

	@GetMapping(value = "/viewcourse")
	public String getAllCourses(Model model) {
		if(Session.check()==false)
			return "login";
		System.err.println(Session.getId());
		model.addAttribute("course",cs.getCourses(Session.getId()));

		return "viewcourse";
	}

	@GetMapping(value="update/changes/{id}")
	public String updateget(Model model,@RequestParam("id") Long id)
	{
		if(Session.check()==false)
			return "login";
		System.out.println(id);
		Course course = cs.getCourseById(id);
		model.addAttribute("course", course);
		return"update";

	}

	@PutMapping(value="/update")
	public String update(Model model,@ModelAttribute Course cr)
	{
		if(Session.check()==false)
			return "login";
		Course co = cs.getCourseById(cr.getId());
		co.setCoursename(cr.getCoursename());
		co.setId(cr.getId());
		co.setPrice(cr.getPrice());
		cs.addCourse(co);
		model.addAttribute("msg","Update Sucess..");
		return"update";
	}

	@DeleteMapping(value="/deletecourse")
	public String delete(@RequestParam("id") Long   id)
	{
		if(Session.check()==false)
			return "login";
		cs.delete(id);
		return "redirect:viewcourse";
	}

	@GetMapping(value="/viewmylessons{id}")
	public String viewLesson(Model model,@RequestParam("id") Long id)
	{
		Course c = cs.getCourseById(id);
		model.addAttribute("course",c);
		model.addAttribute("lessons",c.getLessons());
		return "viewlesson";

	}

	@DeleteMapping(value="/deletelesson")
	public String deleteLesson(@RequestParam("LessonId") long LessonId, @RequestParam("id") long id) {
		cs.deleteLesson(LessonId);
		return "redirect:/viewmylessons?id=" + id;
	}

	@PutMapping(value="/updatelesson")
	public String updateLesson(@ModelAttribute Lesson lesson) {
		// Update the lesson using the provided data
		cs.updateLesson(lesson);
		return "redirect:/viewmylessons?id=" + lesson.getCourse().getId();
	}

	@PutMapping(value="/addanswer")
	public String addAnswer(@RequestParam Long lsnid, @RequestParam Long cmid,@RequestParam String tcomment)
	{
		cms.addans(cmid,tcomment);
		return "redirect:/viewmylessons?id=" + lsnid ;
	}

}
