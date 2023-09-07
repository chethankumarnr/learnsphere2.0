package com.learnsphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnsphere.Service.CommentsService;

@Controller
public class CommentsController {
@Autowired
CommentsService c;

@PostMapping(value="/addcomment1")
public String addCommentQuestion(@RequestParam Long LessonId,@RequestParam("comment") String comment)
{
	c.addCommentQuestion(LessonId,comment);
	System.err.println("Hi "+LessonId+" "+comment);
	
	return "redirect:/mycourses" ;
	
}
	
}
