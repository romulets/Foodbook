package com.foodbook.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="recipe")
public class Recipe {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idRecipe;
	
	@Column(nullable=false, length=70)
	@NotNull(message="O campo nome não pode ficar vazio")
	@NotEmpty(message="O campo nome não pode ficar vazio")
	private String name;
	
	@Column(nullable=false)
	@NotNull(message="O campo descrição não pode ficar vazio")
	@NotEmpty(message="O campo descrição não pode ficar vazio")
	private String description;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column
	private Date publicationDate;
	
	@Column(nullable=false)
	private boolean status;
	
	@ManyToMany(mappedBy="cookedRecipes")
	private Set<User> cookedBy;
	
	@ManyToMany(mappedBy="likedRecipes")
	private Set<User> likedBy;
	
	@OneToMany(mappedBy="recipeCommented")
	private List<Comment> comments;
	
	@ManyToMany
    @JoinTable(name = "recipe_tag", joinColumns = 
    @JoinColumn(name = "idRecipe", referencedColumnName = "idRecipe"), inverseJoinColumns = 
    @JoinColumn(name = "idTag", referencedColumnName = "idTag"))
	private Set<Tag> tags;
	
	@ManyToOne
	@JoinColumn(name="recipe_category_fk")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="recipe_publishedBy_fk")
	private User publishedBy;

	public boolean isLikedBy(User user) {
		for(User searchingUser : likedBy)
			if(searchingUser.getIdUser() == user.getIdUser())
				return true;
		return false;
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

	public Set<User> getCookedBy() {
		return cookedBy;
	}

	public void setCookedBy(Set<User> cookedBy) {
		this.cookedBy = cookedBy;
	}

	public Set<User> getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(Set<User> likedBy) {
		this.likedBy = likedBy;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
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
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Recipe [idRecipe=" + idRecipe + ", name=" + name + ", description=" + description + ", publicationDate="
				+ publicationDate + ", status=" + status + "]";
	}
	
}
