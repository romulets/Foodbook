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
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="user")
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5474666057086545328L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, length=55)
	@NotNull(message="O campo nome não pode ficar vazio")
	@NotEmpty(message="O campo nome não pode ficar vazio")
	private String name;

	@Column
	@NotNull(message="O campo e-mail não pode ficar vazio")
	@Pattern(
			regexp="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
			message="O campo e-mail deve conter um endereço válido"
			)
	private String login;
	
	@Column
	@NotNull(message="O campo senha não pode ficar vazio")
	@NotEmpty(message="O campo senha não pode ficar vazio")
	@Size(min=6, message="O campo senha deve conter mais que 6 caracteres")
	private String password;
	
	@DateTimeFormat
	@Column
	private Date creationDate;
	
	@ManyToMany
	private List<Recipe> cookedBy;
	
	@OneToOne(mappedBy="user")
	@Valid
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

	/*@Override*/
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	/*@Override*/
	public String getUsername() {
		return password;
	}

	/*@Override*/
	public boolean isAccountNonExpired() {
		return true;
	}

	/*@Override*/
	public boolean isAccountNonLocked() {
		return true;
	}

	/*@Override*/
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/*@Override*/
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
