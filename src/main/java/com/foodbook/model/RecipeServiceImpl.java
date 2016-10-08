package com.foodbook.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbook.repository.RecipeRepository;


@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	RecipeRepository rr;
	

	@Override
	public boolean saveRecipe(Recipe recipe)throws Exception  {
		if(recipe == null){
			throw new Exception("Recipe null");
		}
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
			throw new Exception("Invalid id");
		}
		return rr.findById("Recipe", idRecipe);
	}
	
	

}


 