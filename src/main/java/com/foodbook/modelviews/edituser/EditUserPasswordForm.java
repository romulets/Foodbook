package com.foodbook.modelviews.edituser;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class EditUserPasswordForm {
	
	@NotNull(message="O campo senha não pode ficar vazio")
	@NotEmpty(message="O campo senha não pode ficar vazio")
	@Size(min=6, message="O campo senha deve conter menos que 6 caracteres")
	private String password;
	
	private String passwordConfirmation;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

}
