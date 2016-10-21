package com.foodbook.service;

import java.util.List;

import com.foodbook.model.Recipe;

public interface RecipeService {

	public boolean saveRecipe(Recipe recipe) throws Exception;
	
	public boolean updateRecipe(Recipe recipe) throws Exception;
	
	public List<Recipe> listRecipes() throws Exception;
	
	public Recipe findRecipeById(Integer idRecipe) throws Exception;
	
	
}
