package com.foodbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idAddress;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String country;
    @JoinTable(name = "book_publisher", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), 
    		inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id"))
	@OneToOne
	@JoinColumn(name="address_user_fk")
	private User user;
	
}
