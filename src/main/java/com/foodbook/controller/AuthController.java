package com.foodbook.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.model.User;

@Controller
public class AuthController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(Model model) {
		Object anonymous = SecurityContextHolder.getContext()
											    .getAuthentication()
												.getPrincipal();
		
		if (anonymous instanceof User)
			return "redirect:/timeline";
		return "auth/login";	
	}
	
}
