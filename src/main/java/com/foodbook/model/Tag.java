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
	
	@ManyToMany(mappedBy="tags")
	private List<Recipe> recipes;

	public Tag() {}

	public Tag(Integer idTag, String name, List<Recipe> recipes) {
		super();
		this.idTag = idTag;
		this.name = name;
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "Tag [idTag=" + idTag + ", name=" + name + "]";
	}
	
}
