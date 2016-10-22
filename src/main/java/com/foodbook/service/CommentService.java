package com.foodbook.service;

import com.foodbook.model.Comment;
import com.foodbook.model.Recipe;
import com.foodbook.model.User;

public interface CommentService {

	public Comment save(Comment comment, Integer idRecipe, User user);
	
	public Comment save(Comment comment, Recipe recipe, User user);
	
}
