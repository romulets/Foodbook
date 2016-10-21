package com.foodbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.foodbook.model.Recipe;
import com.foodbook.model.User;
import com.foodbook.repository.RecipeRepository;
import com.foodbook.repository.UserRepository;

@Service
@Primary
public class SocialServiceImpl implements SocialService {

	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override	
	public void like(Recipe recipe, User user) {
		recipe = this.recipeRepository.findById(recipe.getIdRecipe());
		
		user.setLikedRecipes(this.recipeRepository.getRecipesLikedBy(user));
		recipe.setLikedBy(this.userRepository.getUsersWhoLiked(recipe));
		
		user.getLikedRecipes().add(recipe);
		recipe.getLikedBy().add(user);
		
		userRepository.update(user);
	}

}
