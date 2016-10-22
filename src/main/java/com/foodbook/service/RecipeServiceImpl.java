package com.foodbook.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.foodbook.exceptions.ResourceNotFoundException;
import com.foodbook.model.Recipe;
import com.foodbook.model.User;
import com.foodbook.repository.RecipeRepository;
import com.foodbook.repository.Repository;

@Service
@Primary
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	RecipeRepository recipeRepo;

	@Override
	public boolean saveRecipe(Recipe recipe, Authentication auth) throws Exception  {
		User currentUser = (User) auth.getPrincipal();
		
		recipe.setPublishedBy(currentUser);
		recipe.setPublicationDate(new Date());
		recipeRepo.save(recipe);
		
		return true;
	}

	@Override
	public boolean updateRecipe(Recipe recipe) throws Exception {
		if(recipe == null || recipe.getIdRecipe() < 0)
			throw new ResourceNotFoundException();

		Recipe persistedRecipe = recipeRepo.findById(recipe.getIdRecipe());
		persistedRecipe.setName(recipe.getName());
		persistedRecipe.setDescription(recipe.getDescription());
		persistedRecipe.setStatus(recipe.isStatus());
		recipeRepo.save(persistedRecipe);
		
		return true;
	}

	@Override
	public List<Recipe> listRecipes() throws Exception {
		List<Recipe> recipes = recipeRepo.list("Recipe");
		
		if(recipes == null)
			throw new Exception ("Doesn`t have recipes to list");
		
		return recipes;
	}
	
	@Override
	public Repository<Recipe> getRepository() {
		return recipeRepo;
	}

}
