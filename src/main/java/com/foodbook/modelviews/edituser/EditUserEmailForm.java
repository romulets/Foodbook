package com.foodbook.modelviews.edituser;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.foodbook.models.User;

public class EditUserEmailForm {

	@NotNull(message="O campo e-mail não pode ficar vazio")
	@Pattern(
			regexp="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
			message="O campo e-mail deve conter um endereço válido"
			)
	private String email;

	public EditUserEmailForm(){}
	
	public EditUserEmailForm(User user) {
		setEmail(user.getLogin());
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email == null)
			return;
		
		this.email = email.trim();
	}
	
}
