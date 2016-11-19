package com.foodbook.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

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
import com.foodbook.modelview.EditUserForm;
import com.foodbook.modelview.RegisterForm;
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
	
	@RequestMapping(value = "profile/edit", method = RequestMethod.GET)
	public String editForm(Model model, Authentication auth) {
		User user = (User) auth.getPrincipal();
		user = userService.getRepository().findById(user.getIdUser());

		model.addAttribute("editUserForm", new EditUserForm(user));
		return "user/edit";
	}
	
	@RequestMapping(value = "profile/edit", method = RequestMethod.POST)
	public String editAction(
			Model model,
			@Valid @ModelAttribute("editUserForm") EditUserForm editUserForm, 
			BindingResult result,
			Authentication auth
			) {
		if(result.hasErrors())
			return "register/form";
				
		User sessionUser = (User) auth.getPrincipal();
		userService.editUser(editUserForm, sessionUser.getIdUser());
		return "redirect:/profile";
	}

	private String makeProfile(Model model, User user, User loggedUser) {
		if(user.getIdUser() == loggedUser.getIdUser())
			model.addAttribute("recipes", recipeService.getRepository().getRecipes(user));
		else
			model.addAttribute("recipes", recipeService.getRepository().getPublishedRecipes(user));
		model.addAttribute("user", user);
		model.addAttribute("isFollowing", isFollowing(loggedUser, user));
		
		return "user/profile";
	}
	
	private boolean isFollowing(User loggedUser, User user) {
		return userService.getRepository().isFollowing(loggedUser, user);
	}

}
