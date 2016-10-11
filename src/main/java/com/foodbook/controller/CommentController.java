package com.foodbook.controller;

import java.security.Principal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodbook.model.Recipe;
import com.foodbook.model.User;
import com.foodbook.modelview.AddCommentForm;
import com.foodbook.repository.CommentRepository;
import com.foodbook.repository.RecipeRepository;

@Controller
public class CommentController {
	
	@PersistenceContext(unitName = "foodbookPU")
	protected EntityManager entityManager;
	
	@Autowired
	CommentRepository commentRepository;
	
	// Dependency for test purposes, delete after recipe pages get done.
	@Autowired
	RecipeRepository rr;

	// Route for test purposes, delete after recipe pages get done.
	@RequestMapping(value="testComment", method=RequestMethod.GET)
	public ModelAndView testComment(Authentication auth){
		ModelAndView mv = new ModelAndView("/CommentTest");
		Recipe recipeCommented = rr.find(1);
		
		AddCommentForm commentForm = new AddCommentForm();	
		
		mv.addObject("recipeCommented", recipeCommented);
	//	mv.addObject("user", user);
		mv.addObject("commentForm", commentForm);
		
		return mv;
	}
	
	@RequestMapping(value="/comment", method=RequestMethod.POST)
	public String comment(
			@Valid @ModelAttribute("register") AddCommentForm commentForm,
			BindingResult result) {
		
		return "redirect:/timeline";	
	}
	
}
