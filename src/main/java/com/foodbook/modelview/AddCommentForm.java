package com.foodbook.modelview;

import javax.validation.Valid;

import com.foodbook.model.Comment;
import com.foodbook.model.Recipe;

public class AddCommentForm {
	
	@Valid
	private Comment comment;
	
	private Recipe recipe;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}
