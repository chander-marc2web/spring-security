package com.marc2web.springsecurity.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.marc2web.springsecurity.dto.User;
import com.marc2web.springsecurity.repositeries.UserRepo;

@ControllerAdvice
public class GlobalController {

	@Autowired
	HttpSession session;
	
	@Autowired
	UserRepo userRepo;
	
	@ModelAttribute("userModel")
	public User getUserModel() {
		
		if(session.getAttribute("userModel") == null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			if(authentication.isAuthenticated()) {
				
				User user = userRepo.findByEmail(authentication.getName());
				if(user!=null) {
						session.setAttribute("userModel", user);
						System.out.println(session.getAttribute("userModel").toString());
						return user;
				}
			}
		}
		
		return (User)session.getAttribute("userModel");
	}
	
}
