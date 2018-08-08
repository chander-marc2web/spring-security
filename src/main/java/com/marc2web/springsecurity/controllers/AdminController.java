package com.marc2web.springsecurity.controllers;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.marc2web.springsecurity.repositeries.UserRepo;
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserRepo userRepo;
	@Autowired
	EntityManager em;

	@GetMapping(value= {"/showUsers","/showUsers?message=update"})
	public ModelAndView showAllUsers(@RequestParam(value="message",required=false) String message) {
		ModelAndView modelAndView = new ModelAndView();
		if(message !=null && !(message.equals(""))) {
			modelAndView.addObject("message", message);
		}
	
		
		modelAndView.addObject("users", em.createQuery("from User u where u.role not in('SUPER_USER','ADMIN')").getResultList());
		return modelAndView;
	}
	
}
