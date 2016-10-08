package com.foodbook.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.foodbook.model.Category;
import com.foodbook.model.CategoryService;
import com.foodbook.model.Recipe;
import com.foodbook.model.RecipeService;
import com.foodbook.model.User;


@Controller
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/auth/new/recipe", method=RequestMethod.POST, name="new_recipe")
	public ModelAndView registerRecipe(Recipe recipe, HttpServletRequest request){
		ModelAndView mv = new ModelAndView("/auth/recipeRegister");
		
		try{
			User currentUser = (User) SecurityContextHolder.getContext()
				    .getAuthentication()
					.getPrincipal();

			
			recipe.setPublishedBy(currentUser);
			recipe.setStatus(true);
			recipe.setPublicationDate(new Date());
		
			recipeService.saveRecipe(recipe);		
			mv.addObject("msg", "Cadastrado com sucesso!");
			
		}catch(Exception e){
			e.printStackTrace();
			//Coloquei para que jogue uma mensagem, se n gostarem disso, pode tirar
			mv.addObject("msg", "Cadastro invalido");
		}				
		return mv;
	}
	
	@RequestMapping(value="/auth/list/recipes", name="list_recipes", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView findRecipe(){
		ModelAndView mv = new ModelAndView("/auth/listRecipe");
			
		try{			
			
			List<Recipe> recipes = recipeService.listRecipes();
			mv.addObject("listRecipes", recipes);
			
		}catch(Exception e){
			e.printStackTrace();
			return mv.addObject("msg", "Busca inválida!");

		}
		return mv;
	}
	
	@RequestMapping(value="/auth/edit/recipe/{pid}", name="edit_recipe", 
			method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView updateRecipe(Recipe recipe, @PathVariable("pid") String id ){
		ModelAndView mv = new ModelAndView("/auth/editRecipe");
		try{
				//Preciso pensar em algo melhor e por isso na service. 
				if(recipe == null || recipe.getIdRecipe() == null){
					Recipe r = recipeService.findRecipeById(new Integer(id));
					mv.addObject("recipe", r);
				}
				
				recipeService.updateRecipe(recipe);
				mv.addObject("recipe", recipe);
				List<Category> categories = categoryService.list();
				mv.addObject("listCategoriesRecipe", categories);
				mv.addObject("msg", "Atualizado com sucesso!");
						
		}catch(Exception e){
			e.printStackTrace();
			return mv.addObject("msg", "Nao foi possivel atualizar a receita ");
		}
		return mv;
	}
	
	@RequestMapping(value="/recipe/desable/{pid}", name="desable_recipe", 
			method=RequestMethod.GET)
	public ModelAndView disableRecipe(@PathVariable("pid") String id ){
		//Entao, a view ainda a gente nao tem como definir, mas pensei em algo como deixar disponivel pro
		//usuario quando listar as receitas dele, ter a opcao de enable e disable 
		ModelAndView mv = new ModelAndView("/auth/listRecipe");
			
		try{
			Recipe recipe = recipeService.findRecipeById(new Integer(id));
			recipe.setStatus(false);
			recipeService.updateRecipe(recipe);
			mv.addObject("msg", "Desabilitado com sucesso!");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "Nao foi possivel desabilitar a receita");
		}
		
		return mv;
	}
	
	
	@RequestMapping(value="/recipe/enable/{pid}", name="enable_recipe", 
			method=RequestMethod.GET)
	public ModelAndView enableRecipe(@PathVariable("pid") String id ){
		//Entao, a view ainda a gente nao tem como definir, mas pensei em algo como deixar disponivel pro
		//usuario quando listar as receitas dele, ter a opcao de enable e disable 
		ModelAndView mv = new ModelAndView("/auth/listRecipe");
			
		try{
			Recipe recipe = recipeService.findRecipeById(new Integer(id));
			recipe.setStatus(true);
			recipeService.updateRecipe(recipe);
			mv.addObject("msg", "Habilitado com sucesso!");
		}catch(Exception e){
			e.printStackTrace();
			mv.addObject("msg", "Nao foi possivel habilitar a receita");
		}
		
		return mv;
	}
}
