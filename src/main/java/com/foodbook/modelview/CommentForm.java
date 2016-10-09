package com.foodbook.modelview;

import javax.validation.Valid;

import com.foodbook.model.Comment;

public class CommentForm {

	public CommentForm(){
		comment = new Comment();
	}
	
	@Valid
	private Comment comment;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
}
