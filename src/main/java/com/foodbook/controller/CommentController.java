package com.foodbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodbook.model.Comment;
import com.foodbook.model.Recipe;
import com.foodbook.model.User;
import com.foodbook.repository.CommentRepository;
import com.foodbook.repository.RecipeRepository;

@Controller
public class CommentController {
	
	@Autowired
	CommentRepository commentRepository;
	
	// Dependency for test purposes, delete after recipe pages get done.
	@Autowired
	RecipeRepository rr;

	// Mapping for test purposes, delete after recipe pages get done.
	@RequestMapping(value="testComment", method=RequestMethod.GET)
	public ModelAndView testComment(){
		ModelAndView mv = new ModelAndView("/CommentTest");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = (User) auth.getPrincipal();
		Recipe r = rr.findById("Recipe", 1);
		
		System.out.println(r);
		
		mv.addObject("recipe", r);
		mv.addObject("currentUser", currentUser);
		
		return mv;
	}
	
	@RequestMapping(value="/comment", method=RequestMethod.POST)
	public String comment(Comment newComment){
		System.out.println("AAA" + newComment);
		
		return "/timeline";
	}
	
}
