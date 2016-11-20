package com.foodbook.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.foodbook.models.User;
import com.foodbook.modelviews.RegisterForm;
import com.foodbook.modelviews.edituser.EditUserPasswordForm;

@Component
public class EditUserPasswordFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return EditUserPasswordForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EditUserPasswordForm form;
		form = (EditUserPasswordForm) target;
		
		if(!form.getPasswordConfirmation().equals(form.getPassword()))
			errors.rejectValue("passwordConfirmation", "", "A senha e a confirmação devem ser iguais");
	}
	
}
