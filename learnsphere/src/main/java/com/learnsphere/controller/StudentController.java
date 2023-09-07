package com.learnsphere.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnsphere.Entities.Course;
import com.learnsphere.Entities.Lesson;
import com.learnsphere.Service.CommentsService;
import com.learnsphere.Service.StudentService;
import com.learnsphere.Service.TraineerServiceImpl;

@Controller
public class StudentController {
	
	@Autowired
	StudentService ss;
	
	@Autowired
	TraineerServiceImpl cs;
	
	@Autowired
	CommentsService cms;
	
	
	
	
	@GetMapping(value="/buycourses")
	public String buyCourses(Model model)
	{
	model.addAttribute("course",ss.buyCoures())	;
	model.addAttribute("check","")	;
		return "buycourses";
	}

	@GetMapping(value="viewlessons{id}")
	public String viewLesson(Model model,@RequestParam("id") Long id)
	{
		model.addAttribute("course",ss.getCourse(id));
		model.addAttribute("lessons",ss.viewLessons(id));
		
		return "coursedetails";
		
	}
	
	@GetMapping(value="/buy")
	public String buyCourse(Model model,Long id)
	{
		System.err.println(id+" cid");
		if(ss.checkbought(id))
		{
			model.addAttribute("course",ss.buyCoures())	;
			model.addAttribute("check","Course Already Bought Check My Courses");
			return "buycourses";
		}
		model.addAttribute("course",ss.buyCoures())	;
		ss.buyCoure(id);
		model.addAttribute("msg","Course added to cart");
		return "buycourses";
	}
	
	@GetMapping(value="/mycourses")
	public String myCourse( Model model)
	{
		System.err.println(ss.myCourses());
		model.addAttribute("cr",ss.myCourses());
		model.addAttribute("msg", "working");
		return "mycourses";
	}
	
	@GetMapping("/lessons/{courseId}")
    public String navigateToLessonsPage(Model model,@PathVariable("courseId") Long courseId) {
       
		Course c = cs.getCourseById(courseId);
		model.addAttribute("course",c);
		model.addAttribute("lessons",c.getLessons());
		return "viewlessons";
    }
	
	@PostMapping("/addcomment")
	public String addcomment(@RequestParam("LessonId") Long LessonId,@RequestParam("question") String question )
	{
		System.err.println(LessonId+" "+question);
		return "redirect:/mycourses";
		
	}
}
