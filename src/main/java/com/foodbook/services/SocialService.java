package com.foodbook.services;

import com.foodbook.models.Recipe;
import com.foodbook.models.User;

public interface SocialService {

	public void like(Recipe recipe, User user);
	
	public void unlike(Recipe recipe, User user);
	
}
