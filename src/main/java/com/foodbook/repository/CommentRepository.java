package com.foodbook.repository;

import org.springframework.stereotype.Repository;

import com.foodbook.model.Comment;
import com.foodbook.model.Recipe;

@Repository
public class CommentRepository extends AbstractRepository<Comment> {
	
	public CommentRepository() {
		super(Comment.class);
	}
	
}
