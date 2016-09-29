package com.foodbook.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="user")
public class User implements UserDetails {

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
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Role> roles = new ArrayList<>();

	public User() {}

	public User(Integer id, String name, String login, String password, Date creationDate, List<Recipe> cookedBy,
			Address address, List<Recipe> likedRecipes, List<Comment> comments) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.creationDate = creationDate;
		this.cookedBy = cookedBy;
		this.address = address;
		this.likedRecipes = likedRecipes;
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Recipe> getCookedBy() {
		return cookedBy;
	}

	public void setCookedBy(List<Recipe> cookedBy) {
		this.cookedBy = cookedBy;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Recipe> getLikedRecipes() {
		return likedRecipes;
	}

	public void setLikedRecipes(List<Recipe> likedRecipes) {
		this.likedRecipes = likedRecipes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getUsername() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", login=" + login + ", password=" + password + ", creationDate="
				+ creationDate + ", cookedBy=" + cookedBy + ", address=" + address + ", likedRecipes=" + likedRecipes
				+ ", comments=" + comments + "]";
	}
	
}
