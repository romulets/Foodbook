package com.foodbook.model;

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
	
}
