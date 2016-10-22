package com.foodbook.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.model.User;

@Controller
public class TimelineController {

	@RequestMapping(value="/timeline", method=RequestMethod.GET)
	public String index(Model model, Authentication auth) {
		User currentUser = (User) auth.getPrincipal();
		model.addAttribute("currentUser", currentUser);	
		
		return "timeline";
	}
	
}
