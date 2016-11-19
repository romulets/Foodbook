package com.foodbook.modelview;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.foodbook.model.Address;
import com.foodbook.model.User;

public class EditUserForm {

	@NotNull(message="O campo nome não pode ficar vazio")
	@NotEmpty(message="O campo nome não pode ficar vazio")
	private String name;
	
	@Valid
	private Address address;

	public EditUserForm(){}
	
	public EditUserForm(User user) {
		name = user.getName();
		address = user.getAddress();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
