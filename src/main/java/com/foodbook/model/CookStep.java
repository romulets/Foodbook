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
@Table(name="cook_step")
public class CookStep {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idCookStep;
	
	@NotNull
	@Column
	private String description;
	
	@NotNull
	@Column
	private Double time;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="cook_step_recipe_fk")
	private Recipe recipe;

	public Integer getIdCookStep() {
		return idCookStep;
	}

	public void setIdCookStep(Integer idCookStep) {
		this.idCookStep = idCookStep;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(Double time) {
		this.time = time;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}	
}
