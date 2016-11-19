package com.foodbook.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.exceptions.ResourceNotFoundException;
import com.foodbook.model.Recipe;
import com.foodbook.model.User;
import com.foodbook.repository.RecipeRepository;
import com.foodbook.service.RecipeService;
import com.foodbook.service.UserService;

@Controller
@Transactional
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipeService recipeService;
	
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String loggedProfile(Model model, Authentication auth) {
		User user = (User) auth.getPrincipal();
		return makeProfile(model, user, user);
	}

	@RequestMapping(value = "profile/{user}", method = RequestMethod.GET)
	public String publicProfile(Model model, @PathVariable("user") int userId, Authentication auth) {
		User user = userService.getRepository().findById(userId);
		User logged = (User) auth.getPrincipal();
		
		if(user == null)
			throw new ResourceNotFoundException();
		
		return makeProfile(model, user, logged);
	}
	
	@RequestMapping(value = "followers/{user}", method = RequestMethod.GET)
	public String followers(Model model, @PathVariable("user") int userId, Authentication auth) {
		User user = userService.getRepository().findById(userId); 
		model.addAttribute("user", user);
		model.addAttribute("isFollowing", isFollowing((User) auth.getPrincipal(), user));
		return "user/followers";
	}
	
	@RequestMapping(value = "following/{user}", method = RequestMethod.GET)
	public String following(Model model, @PathVariable("user") int userId, Authentication auth) {
		User user = userService.getRepository().findById(userId); 
		model.addAttribute("isFollowing", isFollowing((User) auth.getPrincipal(), user));
		model.addAttribute("user", user);
		return "user/following";
	}	

	private String makeProfile(Model model, User user, User loggedUser) {		
		model.addAttribute("recipes", recipeService.getRepository().getPublishedRecipes(user));
		model.addAttribute("user", user);
		model.addAttribute("isFollowing", isFollowing(loggedUser, user));
		
		return "user/profile";
	}
	
	private boolean isFollowing(User loggedUser, User user) {
		return userService.getRepository().isFollowing(loggedUser, user);
	}

}
