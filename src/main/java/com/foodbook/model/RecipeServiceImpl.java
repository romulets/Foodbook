package com.foodbook.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.foodbook.repository.RecipeRepository;

public class RecipeServiceImpl implements RecipeService{

	@Autowired
	RecipeRepository rr;
	

	@Override
	public void saveRecipe(Recipe recipe)throws Exception  {
		if(recipe == null){
			throw new Exception("Recipe null");
		}
		rr.save(recipe);
		
	}

}


