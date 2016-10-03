package com.foodbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(Model model) {
		return "auth/login";
	}
	
}
