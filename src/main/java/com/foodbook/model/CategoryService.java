package com.foodbook.model;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

	public List<Category> list() throws Exception;
}
