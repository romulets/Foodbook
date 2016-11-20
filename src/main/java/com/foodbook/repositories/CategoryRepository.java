package com.foodbook.repositories;

import org.springframework.stereotype.Repository;

import com.foodbook.models.Category;

@Repository
public class CategoryRepository extends AbstractRepository<Category> {
	
	public CategoryRepository() {
		super(Category.class);
	}
	
}
