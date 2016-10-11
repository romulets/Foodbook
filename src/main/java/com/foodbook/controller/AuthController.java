package com.foodbook.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.model.User;

@Controller
public class AuthController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(Model model, Authentication currentUser) {		
		if (currentUser != null)
			return "redirect:/timeline";
		return "auth/login";	
	}
	
}
