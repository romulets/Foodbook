package com.foodbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.foodbook.models.Recipe;
import com.foodbook.models.User;
import com.foodbook.repositories.RecipeRepository;
import com.foodbook.repositories.UserRepository;

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
