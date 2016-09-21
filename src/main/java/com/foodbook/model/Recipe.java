package com.foodbook.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="recipe")
public class Recipe {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idRecipe;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@ManyToMany
	private List<User> cookedBy;
	
	@ManyToMany
	private List<User> likedBy;
	
	@OneToMany(mappedBy="recipeCommented")
	private Comment comments;
	
	@DateTimeFormat
	@Column
	private Date publicationDate;
	
	@ManyToMany
	private List<Recipe> tags;
	
	@ManyToOne
	@JoinColumn(name="recipe_category_fk")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="recipe_publishedBy_fk")
	private User publishedBy;
	
}
