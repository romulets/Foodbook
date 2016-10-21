package com.foodbook.service;

import com.foodbook.model.Recipe;
import com.foodbook.model.User;

public interface SocialService {

	public void like(Recipe recipe, User user);
	
}
