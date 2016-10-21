package com.foodbook.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.foodbook.model.Recipe;
import com.foodbook.model.User;

@Repository
public class RecipeRepository extends AbstractRepository<Recipe> {
	
	public RecipeRepository() {
		super(Recipe.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Recipe> getRecipes(User user) {
		String hql = "SELECT recipe FROM Recipe as recipe WHERE recipe.publishedBy = :user";
		Query query = entityManager.createQuery(hql);
		query.setParameter("user", user);
		query.setMaxResults(10);
		List<Recipe> recipes = (List<Recipe>) query.getResultList();
		
		return recipes;
	}
	
	@SuppressWarnings("unchecked")
	public Set<Recipe> getRecipesLikedBy(User user) {
		String hql = "SELECT recipes FROM User u JOIN u.likedRecipes recipes WHERE u.idUser = :idUser";
		Query query = entityManager.createQuery(hql);
		query.setParameter("idUser", user.getIdUser());
		Set<Recipe> recipes = new HashSet<Recipe>(query.getResultList());
		
		return recipes;
	}
	
}
