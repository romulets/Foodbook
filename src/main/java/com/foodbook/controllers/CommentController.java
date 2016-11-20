package com.foodbook.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.models.User;
import com.foodbook.modelviews.AddCommentForm;
import com.foodbook.services.CommentService;
import com.foodbook.services.CommentServiceImpl;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/comment", method=RequestMethod.POST)
	public String comment(
			@Valid @ModelAttribute("commentForm") AddCommentForm commentForm,
			Authentication auth,
			BindingResult result) {		
		try {
			commentService.save(commentForm.getComment(), commentForm.getIdRecipe(), (User) auth.getPrincipal());
		} catch (Exception error) {
			error.printStackTrace();
		}
		return "redirect:/recipe/" + commentForm.getIdRecipe();	
	}
	
}
