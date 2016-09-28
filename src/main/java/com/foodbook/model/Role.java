package com.foodbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="role")
public class Role implements GrantedAuthority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private String name;
	
	private static final long serialVersionUID = -6905006470042512008L;
	
	@Override
	public String getAuthority() {
		return name;
	}

}
