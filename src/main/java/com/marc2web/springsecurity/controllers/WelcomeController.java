package com.marc2web.springsecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.marc2web.springsecurity.dto.ROLES;
import com.marc2web.springsecurity.dto.User;
import com.marc2web.springsecurity.repositeries.UserRepo;

@Controller

public class WelcomeController {

	@Autowired
	UserRepo userRepo;

	@RequestMapping(value = {"/","/index", "/home" })
	public String goToHome(@RequestParam(value = "message", required = false) String message) {

		return "index";
	}

	@GetMapping("/login")
	public String goToLogin() {
		return "login";
	}
	@GetMapping("/signup")
	public ModelAndView goToRegister(@RequestParam(value="message",required=false) String message) {
		User user = new User();
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("user", user);
		if(message!=null)
		modelAndView.addObject("message", message);	
		return modelAndView;
	}
	
	@PostMapping("/register")
	public String saveUser(User user) {
		user.setActive(false);
		user.setRole(ROLES.USER.toString());
		userRepo.save(user);
		System.out.println(user.toString());
		return "redirect:/signup?message=sucess";
	}
	

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "/error/access-denied";
	}
	
	@GetMapping(value= {"/user","/user/home","/user/index"})
	public String userIndex() {
		return  "user/index";
	}
}
