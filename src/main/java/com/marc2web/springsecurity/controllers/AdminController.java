package com.marc2web.springsecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.marc2web.springsecurity.dto.User;
import com.marc2web.springsecurity.repositeries.UserRepo;

@Controller
@RequestMapping("/adminstrator")
public class AdminController {

	@Autowired
	UserRepo userRepo;
	
	
	@GetMapping(value= {"/showUsers","/showUsers?message=delete","/showUsers?message=update"})
	public ModelAndView showAllUsers(@RequestParam(value="message",required=false) String message) {
		ModelAndView modelAndView = new ModelAndView();
		if(message !=null && !(message.equals(""))) {
			modelAndView.addObject("message", message);
		}
		modelAndView.addObject("users", userRepo.findAll());
		return modelAndView;
	}
	@GetMapping("/delete/{id}/user")
	public String deleteUser(@PathVariable("id") Integer id) {
		
		userRepo.deleteById(id);
		return "redirect:/admistrator/showUsers?message=delete";
	}
	
	@GetMapping("/update/{id}/user")
	public String updateUserForm(@PathVariable("id") Integer id,Model model) {
		User user = userRepo.getOne(id);
		model.addAttribute("user", user);
		return "adminstrator/updateUsers";
	}
	
	@PostMapping("/update/user")
	public String updateUser(User user) {
		System.out.println(user.getId());
		User oldUserData = userRepo.getOne(user.getId());
		oldUserData.setEmail(user.getEmail());		
		oldUserData.setUserName(user.getUserName());
		oldUserData.setRole(user.getRole());
		userRepo.save(oldUserData);
		return "redirect:/admistrator/showUsers?message=update";
	}
	
	
}
