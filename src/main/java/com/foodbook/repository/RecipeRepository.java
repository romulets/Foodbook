package com.foodbook.repository;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.foodbook.infrastructure.AbstractRepository;
import com.foodbook.model.Recipe;

@Repository
public class RecipeRepository extends AbstractRepository<Recipe> {
	

}
