package com.foodbook.service;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.foodbook.model.Comment;
import com.foodbook.model.Recipe;
import com.foodbook.model.User;
import com.foodbook.repository.CommentRepository;
import com.foodbook.repository.RecipeRepository;

@Service
@Primary
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Override
	public Comment save(Comment comment, Integer idRecipe, User user) {
		Recipe recipe;
		recipe = recipeRepository.findById(idRecipe);
		return save(comment, recipe, user);
	}
	
	public Comment save(Comment comment, Recipe recipe, User user) {
		comment.setRecipeCommented(recipe);
		comment.setUser(user);
		comment.setPublicationDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		
		commentRepository.save(comment);
		return comment;
	}
	
}
