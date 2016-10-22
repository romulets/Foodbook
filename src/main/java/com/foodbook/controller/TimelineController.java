package com.foodbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.model.User;
import com.foodbook.repository.RecipeRepository;

@Controller
public class TimelineController {

	@Autowired
	private RecipeRepository recipeRepository;
	
	@RequestMapping(value="/timeline", method=RequestMethod.GET)
	public String index(Model model, Authentication auth) {
		User user = (User) auth.getPrincipal();
		model.addAttribute("recipes", recipeRepository.getRecipesForTimeline(user));	
		return "timeline";
	}
	
}
