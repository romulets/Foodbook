package com.foodbook.modelviews;

import javax.validation.Valid;

import com.foodbook.models.Comment;

public class AddCommentForm {
	
	@Valid
	private Comment comment;
	
	private Integer idRecipe;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Integer getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(Integer idRecipe) {
		this.idRecipe = idRecipe;
	}
	
}
