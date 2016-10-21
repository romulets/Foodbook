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


@Service
@Primary
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	RecipeRepository rr;
	

	@Override
	public boolean saveRecipe(Recipe recipe)throws Exception  {
		User currentUser = (User) SecurityContextHolder.getContext()
			    .getAuthentication()
				.getPrincipal();
		
		recipe.setPublishedBy(currentUser);
		recipe.setPublicationDate(new Date());
		rr.save(recipe);
		return true;
		
	}


	@Override
	public boolean updateRecipe(Recipe recipe) throws Exception {
		if(recipe == null){
			throw new Exception("Recipe null");

		}
		rr.update(recipe);
		return true;
		
	}


	@Override
	public List<Recipe> listRecipes() throws Exception {
		List<Recipe> recipes = rr.list("Recipe");
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
		return rr.findById(idRecipe);
	}

}


 