package com.foodbook.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idCategory;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy="category")
	private List<Recipe> recipes;

	public Category() {}

	public Category(Integer idCategory, String name, String description, List<Recipe> recipes) {
		super();
		this.idCategory = idCategory;
		this.name = name;
		this.description = description;
		this.recipes = recipes;
	}

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", name=" + name + ", description=" + description + "]";
	}
	
}
