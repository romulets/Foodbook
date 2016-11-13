package com.foodbook.modelview;

import com.foodbook.model.Recipe;
import com.foodbook.model.User;

public class SearchForm {
	
	private User user;
	private Recipe recipe;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Recipe getRecipe() {
		return recipe;
	}
	
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}
