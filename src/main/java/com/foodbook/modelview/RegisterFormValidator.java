package com.foodbook.modelview;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.foodbook.model.User;

public class RegisterFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		RegisterForm form;
		form = (RegisterForm) target;
		
		User user;
		user = form.getUser();
		
		if( !form.getPasswordConfirmation().equals(user.getPassword())){
			errors.rejectValue("passwordConfirmation", "", "A senha e a confirmação devem ser iguais");
		}		
	}
	
}
