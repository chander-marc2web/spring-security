package com.marc2web.springsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class WelcomeController {

	@RequestMapping(value={"/","/index","/home","/logout"})
	public String goToHome(@RequestParam(value="message",required=false) String message){
		
	return "index";	
	}
	
	@RequestMapping("/login")
	public String goToLogin(){
		return "login";
	}
	

}
