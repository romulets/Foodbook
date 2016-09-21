package com.foodbook.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tag")
public class Tag {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idTag;
	
	@Column
	private String name;
	
	@ManyToMany
	private List<Recipe> recipes;
	
}
