package com.foodbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idAddress;
	
	@Column
	@NotNull(message="O campo cidade é obrigatório")
	@NotEmpty(message="O campo cidade é obrigatório")
	private String city;
	
	@Column
	@NotNull(message="O campo estado é obrigatório")
	@NotEmpty(message="O campo estado é obrigatório")
	private String state;
	
	@Column
	@NotNull(message="O campo país é obrigatório")
	@NotEmpty(message="O campo país é obrigatório")
	private String country;

	@OneToOne
	@JoinColumn(name="address_user_fk")
	private User user;
    
	public Address() {}
	
	public Address(Integer idAddress, String city, String state, String country, User user) {
		super();
		this.idAddress = idAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.user = user;
	}
	
	public Integer getIdAddress() {
		return idAddress;
	}
	
	public void setIdAddress(Integer idAddress) {
		this.idAddress = idAddress;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [idAddress=" + idAddress + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
  
}
