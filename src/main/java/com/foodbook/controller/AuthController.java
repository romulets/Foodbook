package com.foodbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String loginForm() {
		return "auth/login";
	}

	
}
