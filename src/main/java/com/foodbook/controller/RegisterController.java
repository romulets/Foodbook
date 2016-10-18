package com.foodbook.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.model.Role;
import com.foodbook.modelview.RegisterForm;
import com.foodbook.modelview.RegisterFormValidator;
import com.foodbook.repository.RoleRepository;
import com.foodbook.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService service;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.addValidators(new RegisterFormValidator());
	}	

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model, Authentication currentUser) {
		RegisterForm register;
		
		if (currentUser != null)
			return "redirect:/timeline";
	  
		register = new RegisterForm();
		model.addAttribute("register", register);
		return "register/form";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String postRegister(
			@Valid @ModelAttribute("register") RegisterForm register, 
			BindingResult result) {
		Role role;
		
		if(result.hasErrors())
			return "register/form";
		
		role = roleRepository.findRole("ROLE_ADMIN");
		register.getUser().getRoles().add(role);
		
		service.saveUser(register.getUser());
		return "redirect:/timeline";			
	}
	
}