package com.foodbook.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idComment;
	
	@Column
	private Date publicationDate;
	
	@Column
	private String description;
	
	@ManyToOne
	@JoinColumn(name="comment_recipe_fk")
	private Recipe recipeCommented;

	@ManyToOne
	@JoinColumn(name="comment_user_fk")
	private User user;

	public Comment() {}

	public Comment(Integer idComment, Date publicationDate, String description, Recipe recipeCommented, User user) {
		super();
		this.idComment = idComment;
		this.publicationDate = publicationDate;
		this.description = description;
		this.recipeCommented = recipeCommented;
		this.user = user;
	}

	public Integer getIdComment() {
		return idComment;
	}

	public void setIdComment(Integer idComment) {
		this.idComment = idComment;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Recipe getRecipeCommented() {
		return recipeCommented;
	}

	public void setRecipeCommented(Recipe recipeCommented) {
		this.recipeCommented = recipeCommented;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Comment [idComment=" + idComment + ", publicationDate=" + publicationDate + ", description="
				+ description + "]";
	}
	
}
