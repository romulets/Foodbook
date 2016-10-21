package com.foodbook.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.model.User;
import com.foodbook.repository.RecipeRepository;
import com.foodbook.repository.UserRepository;
import com.foodbook.service.UserService;

import javassist.NotFoundException;

@Controller
@Transactional
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String loggedProfile(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return makeProfile(model, user);
	}

	@RequestMapping(value = "profile/{user}", method = RequestMethod.GET)
	public String publicProfile(Model model, @PathVariable("user") int userId) throws NotFoundException {
		User user = userService.getRepository().findById(userId);
		
		if(user == null)
			return "redirect:/timeline";
		
		return makeProfile(model, user);
	}

	private String makeProfile(Model model, User user) {
		model.addAttribute("recipes", recipeRepository.getRecipes(user));
		model.addAttribute("user", user);
		return "user/profile";
	}

}
