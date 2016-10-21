package com.foodbook.service;

import java.util.List;

import com.foodbook.model.Recipe;
import com.foodbook.model.User;
import com.foodbook.repository.Repository;

public interface RecipeService {

	public boolean saveRecipe(Recipe recipe) throws Exception;
	
	public boolean updateRecipe(Recipe recipe) throws Exception;
	
	public List<Recipe> listRecipes() throws Exception;
	
	//Test
	public Repository<Recipe> getRepository();
	
	public Recipe findRecipeById(Integer idRecipe) throws Exception;
	
	
}
