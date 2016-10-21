package com.foodbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.model.Recipe;
import com.foodbook.model.User;
import com.foodbook.modelview.AddLikeForm;
import com.foodbook.repository.RecipeRepository;
import com.foodbook.service.SocialServiceImpl;

@Controller
public class SocialController {
	
	// Delete it after timeline get done.
	@Autowired
	RecipeRepository rr;
	
	@Autowired
	private SocialServiceImpl socialService;

	@RequestMapping(value="/like", method=RequestMethod.POST)
	public String like(
				@ModelAttribute("likeForm") AddLikeForm likeForm, 
				Authentication auth) {
			this.socialService.like(likeForm.getRecipe(), (User) auth.getPrincipal());
		return "redirect:/timeline";
	}
	
	/*
	 * Rout for test purposes.
	 * Delete it after timeline get done.
	 */
	@RequestMapping(value="/like", method=RequestMethod.GET)
	public String like(Model model) {
		Recipe recipe = rr.findById(1);
		model.addAttribute("recipe", recipe);
		model.addAttribute("likeForm", new AddLikeForm());
		
		return "to_delete/like_form_test";
	}
	
}
