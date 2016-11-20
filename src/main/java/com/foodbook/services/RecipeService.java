package com.foodbook.services;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.foodbook.models.Recipe;
import com.foodbook.repositories.RecipeRepository;
import com.foodbook.repositories.Repository;

public interface RecipeService {

	public boolean saveRecipe(Recipe recipe, Authentication auth) throws Exception;
	
	public boolean updateRecipe(Recipe recipe) throws Exception;
	
	public List<Recipe> listRecipes() throws Exception;
	
	public RecipeRepository getRepository();
	
}
