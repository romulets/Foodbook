package com.foodbook.services;

import com.foodbook.models.Comment;
import com.foodbook.models.Recipe;
import com.foodbook.models.User;

public interface CommentService {

	public Comment save(Comment comment, Integer idRecipe, User user);
	
	public Comment save(Comment comment, Recipe recipe, User user);
	
}
