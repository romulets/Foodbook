package com.foodbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.model.User;
import com.foodbook.modelview.AddLikeForm;
import com.foodbook.service.SocialServiceImpl;

@Controller
public class SocialController {
	
	@Autowired
	private SocialServiceImpl socialService;

	@RequestMapping(value="/like", method=RequestMethod.POST)
	public String like(
				@ModelAttribute("likeForm") AddLikeForm likeForm, 
				Authentication auth) {
			this.socialService.like(likeForm.getRecipe(), (User) auth.getPrincipal());
		return "redirect:/timeline";
	}
	
}
