package com.foodbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ingredient")
public class Ingredient {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idRecipe;
	
	@NotNull
	@Column
	private Double measurement;
	
	@Column
	private String unity;
	
	@Column
	private String description;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="ingredient_recipe_fk")
	private Recipe recipe;

	public int getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(int idRecipe) {
		this.idRecipe = idRecipe;
	}

	public double getMeasurement() {
		return measurement;
	}

	public void setMeasurement(double measurement) {
		this.measurement = measurement;
	}

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}	
}
