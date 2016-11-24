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
import org.springframework.web.multipart.MultipartFile;

import com.foodbook.models.User;
import com.foodbook.modelviews.edituser.EditUserBasicForm;
import com.foodbook.modelviews.edituser.EditUserEmailForm;
import com.foodbook.modelviews.edituser.EditUserPasswordForm;
import com.foodbook.services.UserService;
import com.foodbook.validators.EditUserEmailFormValidator;
import com.foodbook.validators.EditUserPasswordFormValidator;

@Controller
public class EditUserController {

	@Autowired
	private UserService userService;
	
	@InitBinder("editUserEmailForm")
	protected void initBinderEmailForm(WebDataBinder binder){
		binder.addValidators(new EditUserEmailFormValidator(userService.getRepository()));
	}
	
	@InitBinder("editUserPasswordForm")
	protected void initBinderPasswordForm(WebDataBinder binder){
		binder.addValidators(new EditUserPasswordFormValidator());
	}
	
	@RequestMapping(value = "profile/edit/basic", method = RequestMethod.GET)
	public String editBasicForm(Model model, Authentication auth) {
		User user = (User) auth.getPrincipal();
		user = userService.getRepository().findById(user.getIdUser());

		model.addAttribute("editUserBasicForm", new EditUserBasicForm(user));
		return "user/edit/basic";
	}
	
	@RequestMapping(value = "profile/edit/basic", method = RequestMethod.POST)
	public String editBasicAction(
			Model model,
			@Valid @ModelAttribute("editUserBasicForm") EditUserBasicForm editUserForm, 
			BindingResult result,
			@ModelAttribute("photo") MultipartFile photo,
			Authentication auth
			) {
		if(result.hasErrors())
			return "user/edit/basic";
				
		User sessionUser = (User) auth.getPrincipal();
		userService.update(editUserForm, photo, sessionUser.getIdUser());
		return "redirect:/profile";
	}
	
	@RequestMapping(value = "profile/edit/email", method = RequestMethod.GET)
	public String editEmailForm(Model model, Authentication auth) {
		User user = (User) auth.getPrincipal();
		user = userService.getRepository().findById(user.getIdUser());

		model.addAttribute("editUserEmailForm", new EditUserEmailForm(user));
		return "user/edit/email";
	}
	
	@RequestMapping(value = "profile/edit/email", method = RequestMethod.POST)
	public String editEmailAction(
			Model model,
			@Valid @ModelAttribute("editUserEmailForm") EditUserEmailForm editUserForm, 
			BindingResult result,
			Authentication auth
			) {
		if(result.hasErrors())
			return "user/edit/email";
				
		User sessionUser = (User) auth.getPrincipal();
		userService.update(editUserForm, sessionUser.getIdUser());
		return "redirect:/profile";
	}
	
	@RequestMapping(value = "profile/edit/password", method = RequestMethod.GET)
	public String editPassawordForm(Model model, Authentication auth) {
		User user = (User) auth.getPrincipal();
		user = userService.getRepository().findById(user.getIdUser());

		model.addAttribute("editUserPasswordForm", new EditUserPasswordForm());
		return "user/edit/password";
	}
	
	@RequestMapping(value = "profile/edit/password", method = RequestMethod.POST)
	public String editPasswordAction(
			Model model,
			@Valid @ModelAttribute("editUserPasswordForm") EditUserPasswordForm editUserForm, 
			BindingResult result,
			Authentication auth
			) {
		if(result.hasErrors())
			return "user/edit/password";
				
		User sessionUser = (User) auth.getPrincipal();
		userService.update(editUserForm, sessionUser.getIdUser());
		return "redirect:/profile";
	}
	
}
