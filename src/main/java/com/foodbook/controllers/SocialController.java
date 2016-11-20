package com.foodbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.models.User;
import com.foodbook.modelviews.AddLikeForm;
import com.foodbook.services.SocialService;
import com.foodbook.services.SocialServiceImpl;
import com.foodbook.services.UserService;

@Controller
public class SocialController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SocialService socialService;

	@RequestMapping(value="/like", method=RequestMethod.POST)
	public String like(
				@ModelAttribute("likeForm") AddLikeForm likeForm, 
				Authentication auth) {
		
			try{
				this.socialService.like(likeForm.getRecipe(), (User) auth.getPrincipal());
				return "redirect:/recipe/" + likeForm.getRecipe().getIdRecipe();
			} catch(Exception e) {
				return "redirect:/timeline";
			}
		
	}
	
	@RequestMapping(value="/unlike", method=RequestMethod.POST)
	public String unlike(
				@ModelAttribute("likeForm") AddLikeForm unlikeForm, 
				Authentication auth) {
		
		try{
			this.socialService.unlike(unlikeForm.getRecipe(), (User) auth.getPrincipal());
			return "redirect:/recipe/" + unlikeForm.getRecipe().getIdRecipe();
		} catch(Exception e) {
			return "redirect:/timeline";
		}
		
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
	
}
