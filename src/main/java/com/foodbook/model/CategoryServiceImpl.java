package com.foodbook.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbook.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository cr;
	
	@Override
	public List<Category> list() throws Exception {
			List<Category> categories = cr.list("Category");
		if(categories == null){
			throw new Exception ("Doesn`t have categories to list");
		}
		return categories;
	}

}
