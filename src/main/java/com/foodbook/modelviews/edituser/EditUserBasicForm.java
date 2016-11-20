package com.foodbook.modelviews.edituser;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.foodbook.models.Address;
import com.foodbook.models.User;

public class EditUserBasicForm {

	@NotNull(message="O campo nome não pode ficar vazio")
	@NotEmpty(message="O campo nome não pode ficar vazio")
	private String name;
	
	@Valid
	private Address address;

	public EditUserBasicForm(){}
	
	public EditUserBasicForm(User user) {
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
