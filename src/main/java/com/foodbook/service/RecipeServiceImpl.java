package com.foodbook.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.foodbook.model.Recipe;
import com.foodbook.model.User;
import com.foodbook.repository.RecipeRepository;
import com.foodbook.repository.Repository;


@Service
@Primary
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	RecipeRepository recipeRepo;
	

	@Override
	public boolean saveRecipe(Recipe recipe)throws Exception  {
		User currentUser = (User) SecurityContextHolder.getContext()
			    .getAuthentication()
				.getPrincipal();
		
		recipe.setPublishedBy(currentUser);
		recipe.setPublicationDate(new Date());
		recipeRepo.save(recipe);
		return true;
		
	}


	@Override
	public boolean updateRecipe(Recipe recipe) throws Exception {
		if(recipe == null){
			throw new Exception("Recipe null");

		}
		recipeRepo.update(recipe);
		return true;
		
	}


	@Override
	public List<Recipe> listRecipes() throws Exception {
		List<Recipe> recipes = recipeRepo.list("Recipe");
		if(recipes == null){
			throw new Exception ("Doesn`t have recipes to list");
		}
		return recipes;
	}


	@Override
	public Recipe findRecipeById(Integer idRecipe) throws Exception {
		if(idRecipe == null){
			// Create custom exception for NullRecipeIdentifier
			throw new Exception("Invalid id");
		}
		return recipeRepo.findById(idRecipe);
	}
	
	//Test
	@Override
	public Repository<Recipe> getRepository() {
		return recipeRepo;
	}

}


 