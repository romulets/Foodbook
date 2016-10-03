package com.foodbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.model.User;

@Controller
public class AuthController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "auth/login";
	}
	
	@RequestMapping(value="/loginfoi", method=RequestMethod.GET)
	public String loginSucesso(){
		return "/register/LoginSucesso";
	}
	
}
