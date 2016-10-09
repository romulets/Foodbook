package com.foodbook.controller;

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
import com.foodbook.modelview.CommentForm;
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
	public ModelAndView testComment(){
		ModelAndView mv = new ModelAndView("/CommentTest");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		Recipe recipeCommented = rr.find(1);
		CommentForm commentForm = new CommentForm();
		
		commentForm.getComment().setUser(user);
		
		mv.addObject("recipeCommented", recipeCommented);
		mv.addObject("user", user);
		mv.addObject("commentForm", new CommentForm());
		mv.addObject("commentForm.comment.user", user);
		
		return mv;
	}
	
	@RequestMapping(value="/comment", method=RequestMethod.POST)
	public String comment(
			@Valid @ModelAttribute("register") CommentForm commentForm,
			BindingResult result) {
		
		System.out.println("AAA" + commentForm.getComment().getUser());
		
		return "redirect:/timeline";	
	}
	
}
