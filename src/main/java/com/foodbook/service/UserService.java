package com.foodbook.service;

import com.foodbook.model.User;
import com.foodbook.repository.Repository;

public interface UserService {
	
	public void saveUser(User user);
	
	public Repository<User> getRepository();


}
