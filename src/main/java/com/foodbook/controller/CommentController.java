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
	
	@RequestMapping(value="/comment", method=RequestMethod.POST)
	public String comment(
			@Valid @ModelAttribute("register") AddCommentForm commentForm,
			BindingResult result) {
		
		/* 
		 * After the repair of role errors, we just have to
		 * use the method 'findById' to get the Recipe from
		 * database and set It to the comment, then set the 
		 * current date and save It using the method 'save'.
		 * 
		 * To get Recipe's id just 'commentForm.getIdRecipe'.
		 */
		
		return "redirect:/timeline";	
	}
	
}
