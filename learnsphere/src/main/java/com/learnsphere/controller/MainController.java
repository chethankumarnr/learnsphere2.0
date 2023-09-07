package com.learnsphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnsphere.Entities.Users;
import com.learnsphere.Service.ServiceImpl;
import com.learnsphere.Sessiion.Session;

@Controller
public class MainController {

	@Autowired
	ServiceImpl ss;

	@GetMapping(value ="/register")
	public String registerPage()
	{
		try {
			return "register";

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "register";

	}


	@PostMapping(value="/adduser")
	public String adduser(@ModelAttribute  Users users, Model model)
	{
		if(ss.emailExists(users.getEmail())) {
			String s = "User with the same email already exists";
			model.addAttribute("msg",s);
			return "register";
		}
		model.addAttribute("user",users);
		ss.save(users);
		return "welcome";

	}

	@GetMapping(value="/login")
	public String loginPage()
	{
		return"login";
	}

	@PostMapping(value="/verify")
	public String verify(@Param("email") String email, @Param("password") String password,Model model) {

		if(ss.emailExists(email))
		{
			Users usr = ss.getByEmail(email);
			if(password.equals(usr.getPassword()))
			{
				String username=usr.getFname()+" "+usr.getLname();
				model.addAttribute("username",username);
				if(usr.getRole().equals("Student")) {
					Session.setSession(usr.id);
					return "student";
				}
				Session.setSession(usr.id);
				return "trainer";
			}
		}
		else {
			model.addAttribute("msg","User with the above details doesn't exist");
			return "login";
		}
		model.addAttribute("msg","Wrong Credentials...!!");
		return "login";
	}


}


