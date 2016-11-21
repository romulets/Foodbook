package com.foodbook.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.foodbook.models.Role;
import com.foodbook.modelviews.RegisterForm;
import com.foodbook.repositories.RoleRepository;
import com.foodbook.services.UserService;
import com.foodbook.storage.StorageService;
import com.foodbook.validators.RegisterFormValidator;

@Controller
public class RegisterController {

	@Autowired
	private UserService service;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private StorageService storageService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.addValidators(new RegisterFormValidator());
	}	

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model, Authentication auth) {
		RegisterForm register;
		
		if (auth != null)
			return "redirect:/timeline";
	  
		register = new RegisterForm();
		model.addAttribute("register", register);
		return "register/form";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String postRegister(
			@Valid @ModelAttribute("register") RegisterForm register, 
			BindingResult result,
			@RequestParam("photo") MultipartFile file) {
		Role role;
		
		if(result.hasErrors())
			return "register/form";
		
		storageService.store(file);		
		role = roleRepository.findRole("ROLE_USER");
		register.getUser().getRoles().add(role);
		
		service.insertUser(register.getUser());
		return "redirect:/timeline";			
	}
	
}