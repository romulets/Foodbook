package com.foodbook.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.foodbook.model.Comment;
import com.foodbook.model.Recipe;

@Repository
public class CommentRepository extends AbstractRepository<Comment> {
	
	public CommentRepository() {
		super(Comment.class);
	}
	
		
	@SuppressWarnings("unchecked")
	public List<Comment> findByRecipe(Recipe recipe) {
		String hql = "SELECT comment FROM Comment as comment WHERE comment.recipeCommented = :recipe ORDER BY comment.publicationDate ASC";
		Query query = entityManager.createQuery(hql);
		query.setParameter("recipe", recipe);
		List<Comment> comments = (List<Comment>) query.getResultList();
		return comments;
	}

	
}
