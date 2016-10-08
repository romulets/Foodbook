package com.foodbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodbook.model.Category;


public interface CategoryService {

	public List<Category> list() throws Exception;
}
