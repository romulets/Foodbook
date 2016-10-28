package com.foodbook.service;

import org.springframework.security.core.Authentication;

import com.foodbook.model.User;
import com.foodbook.repository.Repository;

public interface UserService {
	
	public void saveUser(User user);
	
	public boolean follow(User user, Authentication auth);
	
	public Repository<User> getRepository();


}
