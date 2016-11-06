package com.foodbook.controller;

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
import com.foodbook.model.User;
import com.foodbook.repository.RecipeRepository;
import com.foodbook.service.UserService;
import com.foodbook.service.UserServiceImpl;

@Controller
@Transactional
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
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
	
	@RequestMapping(value="follow", method=RequestMethod.POST)
	public String follow(
			@ModelAttribute("user") User userToFollow, 
			Authentication auth,
			BindingResult result) {
		userService.follow(userToFollow, auth);
		return "redirect:/profile/"+userToFollow.getIdUser();
	}
	
	@RequestMapping(value="unfollow", method=RequestMethod.POST)
	public String unfollow(
			@ModelAttribute("user") User userToUnfollow, 
			Authentication auth,
			BindingResult result) {
		userService.unfollow(userToUnfollow, auth);
		return "redirect:/profile/"+userToUnfollow.getIdUser();
	}

	private String makeProfile(Model model, User user, User loggedUser) {		
		model.addAttribute("recipes", recipeRepository.getPublishedRecipes(user));
		model.addAttribute("user", user);
		boolean isFollowing = userService.getRepository().isFollowing(loggedUser, user);
		model.addAttribute("isFollowing", isFollowing);
		
		return "user/profile";
	}

}
