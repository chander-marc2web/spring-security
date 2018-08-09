package com.marc2web.springsecurity.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value = {"/","/index", "/home" })
	public String goToHome(@RequestParam(value = "message", required = false) String message) {

		return "index";
	}

	
	@GetMapping(value= {"/login"})
	public String goToLogin(@RequestParam(value="error",required=false) String message,Model model) {
		if(message!=null && message.equals("true")) {
			model.addAttribute("message", "Please Enter Valid Credentials!");
		}
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
	public ModelAndView saveUser(@Valid User user,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("register");
			modelAndView.addObject("user", user);
			return modelAndView;
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserName(user.getUserName().toLowerCase());
		user.setEmail(user.getEmail().toLowerCase());
		user.setRole(ROLES.ROLE_ADMIN.toString());
		user.setactive(false);
		userRepo.save(user);
		System.out.println(user.toString());
		return new ModelAndView("redirect:/signup").addObject("message", "success");
	}
	

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "/error/access-denied";
	}
	
	@GetMapping(value= {"/user","/user/home","/user/index"})
	public String userIndex() {
		return  "user/index";
	}
	
	@GetMapping(value= {"/adminstrator/index","/adminstrator","/adminstrator/home"})
	public String adminstratorIndex() {
		return "adminstrator/index";
	}
	@GetMapping(value= {"/admin/index","/admin","/admin/home"})
	public String adminIndex() {
		return "admin/index";
	}
}
