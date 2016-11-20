package com.foodbook.validators;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.foodbook.models.User;
import com.foodbook.modelviews.edituser.EditUserEmailForm;
import com.foodbook.repositories.UserRepository;

@Component
public class EditUserEmailFormValidator implements Validator{

	private UserRepository repos;
	
	public EditUserEmailFormValidator(UserRepository repos) {
		this.repos = repos;	
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return EditUserEmailForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {		
		EditUserEmailForm form;
		form = (EditUserEmailForm) target;
		
		User logged = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(logged.getLogin().trim().equals(form.getEmail().trim()))
			errors.rejectValue("email", "", "Esse já é seu e-mail atual");
		else if(repos.loadUserByUsername(form.getEmail()) != null)
			errors.rejectValue("email", "", "Esse e-mail já está sendo utilizado por outro usuário");
	}
	
}
