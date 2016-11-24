package com.foodbook.services;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.foodbook.exceptions.ResourceNotFoundException;
import com.foodbook.models.Recipe;
import com.foodbook.models.User;
import com.foodbook.repositories.RecipeRepository;
import com.foodbook.repositories.Repository;
import com.foodbook.storage.ServerPath;
import com.foodbook.storage.StorageService;

@Service
@Primary
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	RecipeRepository recipeRepo;

	@Autowired
	private StorageService storageService;
	
	@Autowired
	private HashConvertorService convertService;

	@Override
	public boolean insert(Recipe recipe, Authentication auth) throws Exception  {
		User currentUser = (User) auth.getPrincipal();
		
		recipe.setPublishedBy(currentUser);
		recipe.setPublicationDate(new Date());
		recipeRepo.save(recipe);
		
		return true;
	}
	
	@Override
	public boolean insert(Recipe recipe, Authentication auth, MultipartFile photo) throws Exception  {
		boolean response = insert(recipe, auth);
		saveImage(recipe, photo);
		update(recipe);
		return response;
	}

	@Override
	public boolean update(Recipe recipe) throws Exception {
		if(recipe == null || recipe.getIdRecipe() < 0)
			throw new ResourceNotFoundException();

		Recipe persistedRecipe = recipeRepo.findById(recipe.getIdRecipe());
		persistedRecipe.setName(recipe.getName());
		persistedRecipe.setDescription(recipe.getDescription());
		persistedRecipe.setStatus(recipe.isStatus());
		persistedRecipe.setPhoto(recipe.getPhoto());
		recipeRepo.save(persistedRecipe);
		
		return true;
	}
	
	@Override
	public boolean update(Recipe recipe, MultipartFile photo) throws Exception {
		saveImage(recipe, photo);
		boolean response = update(recipe);
		return response;
	}
	
	private void saveImage(Recipe recipe, MultipartFile photo) throws Exception {
		String filename;
		if(photo != null && !photo.isEmpty()) {
			filename = String.format("%d_%d_%s", recipe.getIdRecipe(), recipe.getPublishedBy().getIdUser(), recipe.getPublishedBy().getUsername());
			filename = storageService.store(photo, convertService.convert(filename), ServerPath.RECIPE);
			recipe.setPhoto(filename);
		}
	}

	@Override
	public List<Recipe> listRecipes() throws Exception {
		List<Recipe> recipes = recipeRepo.list("Recipe");
		
		if(recipes == null)
			throw new Exception ("Doesn`t have recipes to list");
		
		return recipes;
	}
	
	@Override
	public RecipeRepository getRepository() {
		return recipeRepo;
	}

}
