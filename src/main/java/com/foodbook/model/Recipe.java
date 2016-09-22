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
	private List<Comment> comments;
	
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

	public Recipe() {}

	public Recipe(Integer idRecipe, String name, String description, List<User> cookedBy, List<User> likedBy,
			List<Comment> comments, Date publicationDate, List<Recipe> tags, Category category, User publishedBy) {
		super();
		this.idRecipe = idRecipe;
		this.name = name;
		this.description = description;
		this.cookedBy = cookedBy;
		this.likedBy = likedBy;
		this.comments = comments;
		this.publicationDate = publicationDate;
		this.tags = tags;
		this.category = category;
		this.publishedBy = publishedBy;
	}

	public Integer getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(Integer idRecipe) {
		this.idRecipe = idRecipe;
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

	public List<User> getCookedBy() {
		return cookedBy;
	}

	public void setCookedBy(List<User> cookedBy) {
		this.cookedBy = cookedBy;
	}

	public List<User> getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(List<User> likedBy) {
		this.likedBy = likedBy;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public List<Recipe> getTags() {
		return tags;
	}

	public void setTags(List<Recipe> tags) {
		this.tags = tags;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getPublishedBy() {
		return publishedBy;
	}

	public void setPublishedBy(User publishedBy) {
		this.publishedBy = publishedBy;
	}

	@Override
	public String toString() {
		return "Recipe [idRecipe=" + idRecipe + ", name=" + name + ", description=" + description + ", cookedBy="
				+ cookedBy + ", likedBy=" + likedBy + ", comments=" + comments + ", publicationDate=" + publicationDate
				+ ", tags=" + tags + ", category=" + category + ", publishedBy=" + publishedBy + "]";
	}
	
}
