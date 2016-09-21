package com.foodbook.model;

import java.sql.Date;
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
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, length=55)
	private String name;

	@Column
	private String login;
	
	@Column
	private String password;
	
	@DateTimeFormat
	@Column
	private Date creationDate;
	
	@ManyToMany
	private List<Recipe> cookedBy;
	
	@OneToOne(mappedBy="user")
	private Address address;
	
	@ManyToMany
	private List<Recipe> likedRecipes;
	
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	
}
