package com.foodbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.model.Recipe;
import com.foodbook.model.User;
import com.foodbook.modelview.SearchForm;
import com.foodbook.service.RecipeService;
import com.foodbook.service.UserService;

@Controller
public class SearchController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipeService recipeService;
	
	@RequestMapping(value="search", method=RequestMethod.GET)
	public String search(Model model) {
		model.addAttribute("usersCount", 0);
		model.addAttribute("recipesCount", 0);
		model.addAttribute("query", "");
		model.addAttribute("searchForm", new SearchForm());
		return "search/index";
	}
	
	@RequestMapping(value="search/users", method=RequestMethod.GET)
	public String searchUsers(
			Authentication auth, 
			@Valid @ModelAttribute("searchForm") SearchForm searchForm,
			Model model) {
		
		String query = searchForm.getQuery();
		if(query.length() < 2)
			return "redirect:/search";
		
		List<User> users = userService.getRepository().getUsersByName(query);
		long recipesCount = recipeService.getRepository().getNumberOfRecipesByNameOrDescription(query);
		
		if(users.size() == 0 && recipesCount > 0)
			return "redirect:/search/recipes?query=" + query;
		
		model.addAttribute("users", users);
		model.addAttribute("usersCount", users.size());
		model.addAttribute("recipesCount", recipesCount);
		model.addAttribute("query", query);
		model.addAttribute("searchForm", searchForm);
		
		return "search/users";
	}
	
	@RequestMapping(value="search/recipes", method=RequestMethod.GET)
	public String searchURecipes(
			Authentication auth,
			@Valid @ModelAttribute("searchForm") SearchForm searchForm,
			Model model) {
		
		String query = searchForm.getQuery();
		if(query.length() < 2)
			return "redirect:/search";
		
		long usersCount = userService.getRepository().getNumberOfUsersByName(query);
		List<Recipe> recipes = recipeService.getRepository().getRecipesByNameOrDescription(query);
		
		if(recipes.size() == 0 && usersCount > 0)
			return "redirect:/search/users?query=" + query;
		
		model.addAttribute("recipes", recipes);
		model.addAttribute("recipesCount", recipes.size());
		model.addAttribute("usersCount", usersCount);
		model.addAttribute("query", query);
		model.addAttribute("searchForm", searchForm);
		
		return "search/recipes";
	}
	
}
