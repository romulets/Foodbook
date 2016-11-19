package com.foodbook.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.foodbook.model.User;
import com.foodbook.repository.UserRepository;

public interface UserService {
	
	public void saveUser(User user);
	
	public boolean follow(User user, Authentication auth);
	
	public boolean unfollow(User user, Authentication auth);
	
	public UserRepository getRepository();

}
