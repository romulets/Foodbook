package com.foodbook.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.foodbook.model.Recipe;
import com.foodbook.repository.Repository;

public interface RecipeService {

	public boolean saveRecipe(Recipe recipe, Authentication auth) throws Exception;
	
	public boolean updateRecipe(Recipe recipe) throws Exception;
	
	public List<Recipe> listRecipes() throws Exception;
	
	public Repository<Recipe> getRepository();
	
}
