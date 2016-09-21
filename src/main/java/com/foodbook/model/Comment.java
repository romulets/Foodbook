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
	
}
