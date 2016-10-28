package com.foodbook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(Model model, Authentication auth) {
		if (auth != null)
			return "redirect:/timeline";
		return "auth/login";	
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response,
					Authentication auth) {
	    if (auth != null) 
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    return "redirect:/";
	}
	
}
