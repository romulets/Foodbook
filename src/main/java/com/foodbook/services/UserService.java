package com.foodbook.services;

import org.springframework.security.core.Authentication;

import com.foodbook.models.User;
import com.foodbook.modelviews.edituser.EditUserBasicForm;
import com.foodbook.modelviews.edituser.EditUserEmailForm;
import com.foodbook.modelviews.edituser.EditUserPasswordForm;
import com.foodbook.repositories.UserRepository;

public interface UserService {
	
	public void insertUser(User user);
	
	public void editUser(EditUserBasicForm form, int id);
	public void editUser(EditUserEmailForm form, int id);
	public void editUser(EditUserPasswordForm form, int id);
	
	public boolean follow(User user, Authentication auth);
	
	public boolean unfollow(User user, Authentication auth);
	
	public UserRepository getRepository();

}
