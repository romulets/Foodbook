package com.foodbook.repository;

import org.springframework.stereotype.Repository;

import com.foodbook.model.Category;

@Repository
public class CategoryRepository extends AbstractRepository<Category> {
	
	public CategoryRepository() {
		super(Category.class);
	}
	
}
