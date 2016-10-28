package com.foodbook.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodbook.exceptions.ResourceNotFoundException;
import com.foodbook.model.Recipe;
import com.foodbook.service.CategoryService;
import com.foodbook.service.RecipeService;

@Controller
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="recipe/{id}", method=RequestMethod.GET)
	public String viewRecipe(@PathVariable("id") int id, Model model) {
		Recipe recipe = recipeService.getRepository().findById(id);
		
		if(recipe == null)
			throw new ResourceNotFoundException();
		
		model.addAttribute("recipe", recipe);
		
		return "recipe/profile";
	}
	
	@RequestMapping(value="recipe/add", method=RequestMethod.GET)
	public String newRecipeForm(Model model) {
		model.addAttribute("recipe", new Recipe());
		return "recipe/form";
	}
	
	@RequestMapping(value="recipe/add", method=RequestMethod.POST, name="new_recipe")
	public String registerRecipe(Recipe recipe, Authentication auth){
		try{
			recipeService.saveRecipe(recipe, auth);
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
	public String updateRecipe(Recipe recipe, @PathVariable("id") int id ){
		try {					
			recipe.setIdRecipe(id);
			recipeService.updateRecipe(recipe);
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return "redirect:/recipe/" + id;
	}
	
	@RequestMapping(value="/disable/", name="desable_recipe", 
			method=RequestMethod.POST)
	public ModelAndView disableRecipe(@PathVariable("pid") String id ){
		//Entao, a view ainda a gente nao tem como definir, mas pensei em algo como deixar disponivel pro
		//usuario quando listar as receitas dele, ter a opcao de enable e disable 
		ModelAndView mv = new ModelAndView("/auth/listRecipe");
			
		try {
			Recipe recipe = recipeService.getRepository().findById(new Integer(id));
			recipe.setStatus(false);
			recipeService.updateRecipe(recipe);
			mv.addObject("msg", "Desabilitado com sucesso!");
			
		} catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "Nao foi possivel desabilitar a receita");
		}
		return mv;
	}
	
	
	@RequestMapping(value="/enable/{pid}", name="enable_recipe", 
			method=RequestMethod.GET)
	public ModelAndView enableRecipe(@PathVariable("pid") String id ){
		//Entao, a view ainda a gente nao tem como definir, mas pensei em algo como deixar disponivel pro
		//usuario quando listar as receitas dele, ter a opcao de enable e disable 
		ModelAndView mv = new ModelAndView("/auth/listRecipe");
			
		try {
			Recipe recipe = recipeService.getRepository().findById(new Integer(id));
			recipe.setStatus(true);
			recipeService.updateRecipe(recipe);
			mv.addObject("msg", "Habilitado com sucesso!");
			
		} catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "Nao foi possivel habilitar a receita");
		}
		return mv;
	}
	
}
