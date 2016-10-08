package com.foodbook.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.foodbook.model.Recipe;

@Repository
public class RecipeRepository extends AbstractRepository<Recipe> {
	
	public RecipeRepository() {
		super(Recipe.class);
	}
	
	public Recipe find(Integer id) {
		Recipe recipe = (Recipe) this.entityManager.createQuery("FROM Recipe WHERE idRecipe = 1").getSingleResult();
		return recipe;
	}
	
}
