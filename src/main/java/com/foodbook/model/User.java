package com.foodbook.model;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

	private static final long serialVersionUID = -5474666057086545328L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUser;
	
	@Column(nullable=false, length=55)
	@NotNull(message="O campo nome não pode ficar vazio")
	@NotEmpty(message="O campo nome não pode ficar vazio")
	private String name;

	@Column(unique=true)
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
	
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	@OneToOne(mappedBy="user", fetch=FetchType.EAGER)
	@Valid
	private Address address;
	
	@ManyToMany
    @JoinTable(name = "user_recipe_cook", joinColumns = 
    @JoinColumn(name = "idUser", referencedColumnName = "idUser"), inverseJoinColumns = 
    @JoinColumn(name = "idRecipe", referencedColumnName = "idRecipe"))
	private Set<Recipe> cookedRecipes;
	
	@ManyToMany
    @JoinTable(name = "user_recipe_like", joinColumns = 
    @JoinColumn(name = "idUser", referencedColumnName = "idUser"), inverseJoinColumns = 
    @JoinColumn(name = "idRecipe", referencedColumnName = "idRecipe"))
	private Set<Recipe> likedRecipes;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = 
    @JoinColumn(name = "idUser", referencedColumnName = "idUser"), inverseJoinColumns = 
    @JoinColumn(name = "role", referencedColumnName = "name"))
	private Set<Role> roles;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "user_follow", joinColumns = 
    @JoinColumn(name = "idUser_follower", referencedColumnName = "idUser"), inverseJoinColumns = 
    @JoinColumn(name = "idUser_followed", referencedColumnName = "idUser"))
	private Set<User> following;
	
	@ManyToMany(mappedBy="following")
	private Set<User> followers;

	public User() {
		super();
		this.roles = new HashSet<Role>();
	}

	public User(Integer idUser, String name, String login, String password, Date creationDate,
			Set<Recipe> cookedRecipes, Address address, Set<Recipe> likedRecipes, Set<Role> roles,
			List<Comment> comments) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.login = login;
		this.password = password;
		this.creationDate = creationDate;
		this.cookedRecipes = cookedRecipes;
		this.address = address;
		this.likedRecipes = likedRecipes;
		this.roles = roles;
		this.comments = comments;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer id) {
		this.idUser = id;
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

	public void setCookedRecipes(Set<Recipe> cookedRecipes) {
		this.cookedRecipes = cookedRecipes;
	}

	public void setLikedRecipes(Set<Recipe> likedRecipes) {
		this.likedRecipes = likedRecipes;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Recipe> getLikedRecipes() {
		return likedRecipes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Set<Recipe> getCookedRecipes() {
		return cookedRecipes;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public Set<User> getFollowing() {
		return following;
	}

	public void setFollowing(Set<User> following) {
		this.following = following;
	}

	public Set<User> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<User> friendOf) {
		this.followers = friendOf;
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
		return "User [idUser=" + idUser + ", name=" + name + ", login=" + login + ", password=" + password
				+ ", creationDate=" + creationDate + "]";
	}
	
}
