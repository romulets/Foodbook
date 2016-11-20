package com.foodbook.services;

import java.util.List;

import com.foodbook.models.Category;

public interface CategoryService {

	public List<Category> list() throws Exception;
	
}
