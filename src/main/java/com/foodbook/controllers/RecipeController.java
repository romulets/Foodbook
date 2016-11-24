package com.foodbook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.foodbook.exceptions.ResourceNotFoundException;
import com.foodbook.models.Recipe;
import com.foodbook.modelviews.AddCommentForm;
import com.foodbook.repositories.CommentRepository;
import com.foodbook.services.RecipeService;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private CommentRepository commentRepos;
	
	@RequestMapping(value="recipe/{id}", method=RequestMethod.GET)
	public String viewRecipe(@PathVariable("id") int id, Model model) {
		Recipe recipe = recipeService.getRepository().findById(id);
		
		if(recipe == null)
			throw new ResourceNotFoundException();
		
		model.addAttribute("recipe", recipe);
		model.addAttribute("comments", commentRepos.findByRecipe(recipe));
		model.addAttribute("commentForm", new AddCommentForm());
		
		return "recipe/profile";
	}
	
	@RequestMapping(value="recipe/add", method=RequestMethod.GET)
	public String newRecipeForm(Model model) {
		model.addAttribute("recipe", new Recipe());
		return "recipe/form";
	}
	
	@RequestMapping(value="recipe/add", method=RequestMethod.POST)
	public String registerRecipe(@Valid @ModelAttribute("recipe") Recipe recipe,
			BindingResult result,
			@RequestPart("recipe_image") MultipartFile photo,
			Authentication auth){
		
		if(result.hasErrors())
			return "recipe/form";
		
		try{
			recipeService.insert(recipe, auth, photo);
			return "redirect:/recipe/" + recipe.getIdRecipe();
		} catch(Exception e){
			e.printStackTrace();
			return "redirect:/timeline";
		}				
	}
	
	@RequestMapping(value="recipe/edit/{id}", method=RequestMethod.GET)
	public String editRecipe(@PathVariable("id") Integer id, Model model){
		try{
			Recipe recipe = recipeService.getRepository().findById(id);
			model.addAttribute("recipe", recipe);	
			
			return "recipe/form";
			
		} catch(Exception e){
			e.printStackTrace();
			return "redirect:/timeline";
		}
	}
	
	@RequestMapping(value="/auth/list/recipes", name="list_recipes", 
			method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView findRecipe(){
		ModelAndView mv = new ModelAndView("/auth/listRecipe");
			
		try {
			List<Recipe> recipes = recipeService.listRecipes();
			mv.addObject("listRecipes", recipes);
			
		} catch(Exception e){
			e.printStackTrace();
			return mv.addObject("msg", "Busca inválida!");
		}
		return mv;
	}
	
	@RequestMapping(value="recipe/edit/{id}", name="edit_recipe", 
			method=RequestMethod.POST)
	public String updateRecipe(@Valid @ModelAttribute("recipe") Recipe recipe,
			BindingResult result,
			@RequestPart("recipe_image") MultipartFile photo,
			@PathVariable("id") int id){
		
		if(result.hasErrors())
			return "recipe/form";
		
		try {					
			recipe.setIdRecipe(id);
			recipeService.update(recipe, photo);
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return "redirect:/recipe/" + id;
	}
}
