package com.foodbook.modelview;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.foodbook.model.User;

public class RegisterForm {
	
	@Valid
	private User user;
	
	@NotNull
	private String passwordConfirmation;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
}
