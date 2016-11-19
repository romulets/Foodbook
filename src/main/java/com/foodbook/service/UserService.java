package com.foodbook.service;

import org.springframework.security.core.Authentication;

import com.foodbook.model.User;
import com.foodbook.modelview.EditUserForm;
import com.foodbook.repository.UserRepository;

public interface UserService {
	
	public void insertUser(User user);
	
	public void editUser(EditUserForm user, int id);
	
	public boolean follow(User user, Authentication auth);
	
	public boolean unfollow(User user, Authentication auth);
	
	public UserRepository getRepository();

}
