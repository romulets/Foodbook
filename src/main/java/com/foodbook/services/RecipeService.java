package com.foodbook.services;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import com.foodbook.models.Recipe;
import com.foodbook.repositories.RecipeRepository;
import com.foodbook.repositories.Repository;

public interface RecipeService {

	public boolean insert(Recipe recipe, Authentication auth) throws Exception;
	public boolean insert(Recipe recipe, Authentication auth, MultipartFile photo) throws Exception;
	
	public boolean update(Recipe recipe) throws Exception;
	public boolean update(Recipe recipe, MultipartFile photo) throws Exception;
	
	public List<Recipe> listRecipes() throws Exception;
	
	public RecipeRepository getRepository();
	
}
