package com.foodbook.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foodbook.model.User;
import com.foodbook.modelview.AddCommentForm;
import com.foodbook.service.CommentServiceImpl;

@Controller
public class CommentController {
	
	@Autowired
	private CommentServiceImpl commentService;
	
	@RequestMapping(value="/comment", method=RequestMethod.POST)
	public String comment(
			@Valid @ModelAttribute("commentForm") AddCommentForm commentForm,
			Authentication currentUser,
			BindingResult result) {		
		try {
			commentService.save(commentForm.getComment(), commentForm.getIdRecipe(), (User) currentUser);
			
		} catch (Exception error) {
			error.printStackTrace();
		}
		return "redirect:/timeline";	
	}
	
}