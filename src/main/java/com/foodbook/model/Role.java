package com.foodbook.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="role")
public class Role implements GrantedAuthority {
	
	public static final String NORMAL_USER = "normal-user";
			
	@Id
	@Column
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> user;
	
	private static final long serialVersionUID = -6905006470042512008L;
	
	public Role() {}

	public Role(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getAuthority() {
		return name;
	}

}
